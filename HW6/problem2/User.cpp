//
// Created by Jiwon Kim on 2020/12/23.
//

#include "User.h"

User::User(std::string id, std::string password) : id(id), password(password){

}

bool User::Auth(std::string given_password) {
    return given_password == password;
}
