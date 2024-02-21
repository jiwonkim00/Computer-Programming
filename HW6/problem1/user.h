#ifndef PROBLEM1_USER_H
#define PROBLEM1_USER_H

#include <string>
#include <vector>
#include "product.h"

class User {
public:
    User(std::string name, std::string password);
    const std::string name;
    bool matchPassword (std::string given_password);
    std::vector<Product*> cart;
    bool premium;
    std::vector<Product*> purchaseHistory;
private:
    std::string password;
};

class NormalUser : public User {
public :
    NormalUser(std::string name, std::string password);
};

class PremiumUser : public User {
public :
    PremiumUser(std::string name, std::string password);
};

#endif //PROBLEM1_USER_H
