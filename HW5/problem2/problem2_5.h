//
// Created by Jiwon Kim on 2020/11/29.
//

#ifndef PROBLEM2_PROBLEM2_5_H
#define PROBLEM2_PROBLEM2_5_H
#include <iostream>
#include <string>
#include <utility>
#include <set>
#include <vector>
#include <tuple>
#include "problem2_2.h"
#include "problem2_3.h"
#include "problem2_4.h"
typedef std::pair<std::string, std::multiset<int>> player;

int tournament(std::vector<std::pair<std::string, std::multiset<int>>> players);
bool winner(std::pair<std::string, std::multiset<int>> a, std::pair<std::string, std::multiset<int>> b);
std::vector<player> round (std::vector<player> players);

#endif //PROBLEM2_PROBLEM2_5_H
