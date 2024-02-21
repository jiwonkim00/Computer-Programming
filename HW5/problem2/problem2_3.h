//
// Created by Jiwon Kim on 2020/11/28.
//

#ifndef PROBLEM2_PROBLEM2_3_H
#define PROBLEM2_PROBLEM2_3_H
#include <iostream>
#include <string>
#include <utility>
#include <set>
#include <vector>
#include <tuple>


std::pair<std::multiset<int>, std::multiset<int>> player_battle(
        std::string type_a, std::multiset<int> a, std::string type_b, std::multiset<int> b
);
int maximize_gain(std::multiset<int> mySet, std::multiset<int> oppSet);
int minimize_loss(std::multiset<int> mySet, std::multiset<int> oppSet);
int minimize_regret(std::multiset<int> mySet, std::multiset<int> oppSet);

#endif //PROBLEM2_PROBLEM2_3_H
