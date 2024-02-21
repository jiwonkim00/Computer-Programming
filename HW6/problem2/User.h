//
// Created by Jiwon Kim on 2020/12/23.
//

#ifndef PROBLEM2_USER_H
#define PROBLEM2_USER_H
#include <string>

class User {
public:
    std::string id;
    User(std::string id, std::string password);
    bool Auth(std::string given_password);

private :
    std::string password;
};




#endif //PROBLEM2_USER_H
