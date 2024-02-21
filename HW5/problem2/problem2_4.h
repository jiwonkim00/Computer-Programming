//
// Created by Jiwon Kim on 2020/11/29.
//

#ifndef PROBLEM2_PROBLEM2_4_H
#define PROBLEM2_PROBLEM2_4_H
#include <iostream>
#include <string>
#include <utility>
#include <set>
#include <vector>
#include <tuple>
#include "problem2_2.h"
#include "problem2_3.h"

bool compareSets (std::multiset<int> a, std::multiset<int> b);
std::pair<std::multiset<int>, std::multiset<int>> player_vs_player(
        std::string type_a, std::multiset<int> a, std::string type_b, std::multiset<int> b
);









#endif //PROBLEM2_PROBLEM2_4_H
