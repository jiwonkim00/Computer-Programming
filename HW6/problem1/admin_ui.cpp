#include "admin_ui.h"
using namespace std;

AdminUI::AdminUI(ShoppingDB &db, std::ostream& os): UI(db, os) { }

void AdminUI::add_product(std::string name, int price) {
    // TODO: For problem 1-1
    if (price <= 0) {
        os << "ADMIN_UI: Invalid price." << endl;
        return;
    }
    db.addProduct(name, price);
    os << "ADMIN_UI: " << name << " is added to the database." << endl;
}

void AdminUI::edit_product(std::string name, int price) {
    // TODO: For problem 1-1
    Product* product = db.getProduct(name);
    if (product == nullptr) {
        os << "ADMIN_UI: Invalid product name." << endl;
        return;
    }
    if (price <= 0) {
        os << "ADMIN_UI: Invalid price." << endl;
        return;
    }
    (*product).price = price;
    os << "ADMIN_UI: " << name << " is modified from the database." << endl;
}

void AdminUI::list_products() {
    // TODO: For problem 1-1
    vector<Product> productList = db.getListofProduct();
    if (productList.empty()) {
        os << "ADMIN_UI: Products: []" <<endl;
        return;
    }
    vector<Product>::iterator iter;
    os << "ADMIN_UI: Products: [" ;
    for (iter = productList.begin(); iter != productList.end(); iter++) {
        if (iter != productList.begin()) {
            os << ", ";
        }
        os << "(" << (*iter).name << ", " << (*iter).price << ")";
    }
    os << "]" <<endl;
}
