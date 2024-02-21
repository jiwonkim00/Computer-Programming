#include <vector>
#include "client_ui.h"
#include "product.h"
#include <math.h>
#include "user.h"
using namespace std;

ClientUI::ClientUI(ShoppingDB &db, std::ostream& os) : UI(db, os), current_user() { }

ClientUI::~ClientUI() {
    delete current_user;
}

void ClientUI::signup(std::string username, std::string password, bool premium) {
    // TODO: For problem 1-2
    db.addUser(username, password, premium);
    os << "CLIENT_UI: " << username << " is signed up." << endl;
}

void ClientUI::login(std::string username, std::string password) {
    // TODO: For problem 1-2
    if (current_user != nullptr) {
        os << "CLIENT_UI: Please logout first." <<endl;
        return;
    }
    if (db.findUser(username, password) == nullptr) {
        os << "CLIENT_UI: Invalid username or password." <<endl;
        return;
    }
    else {
        current_user = db.findUser(username, password);
        os << "CLIENT_UI: " << username << " is logged in." <<endl;
    }
}

void ClientUI::logout() {
    // TODO: For problem 1-2
    if (current_user == nullptr) {
        os << "CLIENT_UI: There is no logged-in user." <<endl;
        return;
    }
    os << "CLIENT_UI: " << current_user->name << " is logged out." <<endl;
    current_user = nullptr;
}

void ClientUI::add_to_cart(std::string product_name) {
    // TODO: For problem 1-2
    if (current_user == nullptr) {
        os << "CLIENT_UI: Please log in first." <<endl;
        return;
    }
    Product* product = db.getProduct(product_name);
    if (product == nullptr) {
        os << "CLIENT_UI: Invalid product name." << endl;
        return;
    }
    (current_user->cart).push_back(product);
    os << "CLIENT_UI: " << product->name << " is added to the cart." << endl;
}

// TODO: For problem 1-2.
void ClientUI::list_cart_products() { //this is the problem!!!!
    if (current_user == nullptr) {
        os << "CLIENT_UI: Please log in first." <<endl;
        return;
    }
    os << "CLIENT_UI: Cart: [" ;
    for (auto iter = (current_user->cart).begin(); iter != (current_user->cart).end(); iter++) {
        if (iter != (current_user->cart).begin()) {
            os << ", " ;
        }
        os << "(" << (*iter)->name << ", ";
        if (current_user->premium) {
            os << round((*iter)->price * 0.9) << ")";
        }
        else {
            os << (*iter)->price << ")";
        }
    }
    os << "]" <<endl;
}


void ClientUI::buy_all_in_cart() {  //this is also a problem!!
    // TODO: For problem 1-2
    if (current_user == nullptr) {
        os << "CLIENT_UI: Please log in first." <<endl;
        return;
    }
    os << "CLIENT_UI: Cart purchase completed. Total price: " ;
    int price = 0;
    for (auto & iter : current_user->cart) {
        if (current_user->premium) {
            price += (int)round((iter->price) * 0.9);
        }
        else {
            price += iter->price;
        }
        current_user->purchaseHistory.push_back(iter);
    }
    os << price << "." <<endl;
    (current_user->cart).clear();
}

void ClientUI::buy(std::string product_name) {  //this is also problem!!
    // TODO: For problem 1-2
    if (current_user == nullptr) {
        os << "CLIENT_UI: Please log in first." <<endl;
        return;
    }
    auto product = db.getProduct(product_name);
    if (product == nullptr) {
        os << "CLIENT_UI: Invalid product name." << endl;
        return;
    }
    int price = 0;
    if (current_user->premium) {
        price = (int)round((product->price) * 0.9);
    }
    else {
        price = product->price;
    }
    current_user->purchaseHistory.push_back(product);
    os << "CLIENT_UI: Purchase completed. Price: " << price << "." <<endl;
}

// TODO: For problem 1-3.
void ClientUI::recommend_products() {
    if (current_user == nullptr) {
        os << "CLIENT_UI: Please log in first." <<endl;
        return;
    }
    vector<Product*> recommendList;
    if (current_user->premium) {  //recommend list for premium user
        recommendList = db.recommendPremium(current_user);
    }
    else {  //recommend list  for normal user
        int i = 0;
        for (auto iter = current_user->purchaseHistory.rbegin(); iter != current_user->purchaseHistory.rend(); iter++) {
            if (find(recommendList.begin(), recommendList.end(), *iter) != recommendList.end()) {
                continue;
            }
            recommendList.push_back(*iter);
            if (++i == 3) {
                break;
            }
        }
    }

    os << "CLIENT_UI: Recommended products: [" ;
    for (auto iter = recommendList.begin(); iter != recommendList.end(); iter++) {
        if (iter != recommendList.begin()) {
            os << ", " ;
        }
        os << "(" << (*iter)->name << ", ";
        if (current_user->premium) {
            os << round((*iter)->price * 0.9) << ")";
        }
        else {
            os << (*iter)->price << ")";
        }
    }
    os << "]" <<endl;
}
