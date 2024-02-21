//
// Created by Jiwon Kim on 2020/12/01.
//

#ifndef PROBLEM2_PROBLEM2_6_H
#define PROBLEM2_PROBLEM2_6_H
#include <iostream>
#include <string>
#include <utility>
#include <set>
#include <vector>
#include <tuple>
#include "problem2_2.h"
#include "problem2_3.h"
#include "problem2_4.h"
#include "problem2_5.h"
typedef std::pair<std::string, std::multiset<int>> player;


int steady_winner(std::vector<std::pair<std::string, std::multiset<int>>> players);



#endif //PROBLEM2_PROBLEM2_6_H
