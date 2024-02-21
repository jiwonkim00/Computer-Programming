#include <iostream>
#include "shopping_db.h"


using namespace std;

ShoppingDB::ShoppingDB() {

}

void ShoppingDB::addProduct(std::string name, int price) {
    products.push_back(new Product(name, price));
}

Product *ShoppingDB::getProduct(std::string name) {
    for (auto iter = products.begin(); iter != products.end(); iter++) {
        if ( (*iter)->name == name) {
            return *iter;
        }
    }
    return nullptr;
}

std::vector<Product> ShoppingDB::getListofProduct() {
    vector<Product> productList;
    for (auto iter = products.begin(); iter != products.end(); iter++) {
        productList.push_back(*(*iter));
    }
    return productList;
}

ShoppingDB::~ShoppingDB() {
    vector<Product*>::iterator iter;
    for (iter = products.begin(); iter != products.end(); iter++) {
        delete (*iter);
    }
    vector<User*>::iterator useriter;
    for (useriter = users.begin(); useriter != users.end(); useriter++) {
        delete (*useriter);
    }
}

void ShoppingDB::addUser(std::string name, std::string password, bool premium) {
    if (premium) {
        auto* ptr = new PremiumUser(name, password);
        ptr->premium = true;
        users.push_back(ptr);
    }
    else {
        auto* ptr = new NormalUser(name, password);
        ptr->premium = false;
        users.push_back(ptr);
    }
}

User* ShoppingDB::findUser(std::string name, std::string password) {
    for (auto & user : users) {
        if ( user->name == name) {
            if (user->matchPassword(password)) {
                return user;
            }
        }
    }
    return nullptr;
}

vector<Product*> ShoppingDB::recommendPremium(User* currentUser) {
    vector<pair<User*, int>> otherUserSimilarity;
    for (auto & user : users) {
        if (user == currentUser) {
            continue;
        }
        int sim = getSimilarity(user, currentUser);
        pair<User*, int> simpair(user, sim);
        otherUserSimilarity.push_back(simpair);
    }
    sort(otherUserSimilarity.begin(), otherUserSimilarity.end());


    vector<Product*> recommendList;
    int i = 0;
    for (auto& iter : otherUserSimilarity) {
        Product* product = (iter.first->purchaseHistory).back();
        if (find(recommendList.begin(), recommendList.end(), product) != recommendList.end()) {
            continue;
        }
        recommendList.push_back(product);
        if (++i == 3) {
            break;
        }
    }

    return recommendList;
}

int ShoppingDB::getSimilarity(User *user, User *currentUser) {
    vector<Product*> userSet = eliminateRepeat(user->purchaseHistory);
    vector<Product*> currentSet = eliminateRepeat(currentUser->purchaseHistory);
    int result = 0;
    for (auto & iter : currentSet) {
        if (find(userSet.begin(), userSet.end(), iter) != userSet.end()) {
            result ++;
        }
    }
    return result;
}

vector<Product *> ShoppingDB::eliminateRepeat(vector<Product*> list) {
    vector<Product*> returnList;
    for (auto & iter : list) {
        if (find(returnList.begin(), returnList.end(), iter) == returnList.end()) {
            returnList.push_back(iter);
        }
    }
    return returnList;
}

bool operator < (const pair<User*, int> &a, const pair<User*, int> &b) {   //for sort, overloading'<'
    return b.second < a.second;
}



