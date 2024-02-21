#ifndef PROBLEM1_SHOPPING_DB_H
#define PROBLEM1_SHOPPING_DB_H

#include <string>
#include <vector>
#include <algorithm>
#include "user.h"
#include "product.h"

class ShoppingDB {
public:
    ShoppingDB();
    void addProduct(std::string name, int price);
    Product* getProduct(std::string name);
    std::vector<Product> getListofProduct();
    ~ShoppingDB();
    void addUser(std::string name, std::string password, bool premium);
    User* findUser(std::string name, std::string password);
    std::vector<Product *> recommendPremium(User *currentUser);

private:
    std::vector<User*> users;
    std::vector<Product*> products;

    static std::vector<Product *> eliminateRepeat(std::vector<Product*> list);
    static int getSimilarity(User *user, User *currentUser);
};

#endif //PROBLEM1_SHOPPING_DB_H
