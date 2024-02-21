#include "user.h"
//#include <iostream>
using namespace std;

User::User(std::string name, std::string password): name(name), password(password) {

}

bool User::matchPassword(std::string given_password) {
    if (given_password == password) {
        return true;
    }
    return false;
}


NormalUser::NormalUser(std::string name, std::string password) : User(name, password) {

}

PremiumUser::PremiumUser(std::string name, std::string password) : User(name, password) {

}
