//
// Created by Jiwon Kim on 2020/11/29.
//

#include "problem2_5.h"
using namespace std;

// TODO 2-5

bool winner(std::pair<std::string, std::multiset<int>> a, std::pair<std::string, std::multiset<int>> b) {
    std::pair<std::multiset<int>, std::multiset<int>> result_pair = player_vs_player(a.first, a.second, b.first, b.second);

    int a_sum = 0;
    for(auto aIter=result_pair.first.begin(); aIter!=result_pair.first.end(); aIter++) {
        a_sum += (*aIter);
    }
    int b_sum = 0;
    for(auto bIter=result_pair.second.begin(); bIter!=result_pair.second.end(); bIter++) {
        b_sum += (*bIter);
    }
    if (a_sum > b_sum) {
        return 0;  //a wins
    }
    else if (b_sum > a_sum) {
        return 1;  //b wins
    }
    else {
        return 0;  //a wins, a has smaller index
    }
} //if 0, 1st player wins. if 1, 2nd player wins.

std::vector<player> round (std::vector<player> players) {
    std::pair<std::string, std::multiset<int>> null_player;
    for (int i = 0; i<players.size()/2; i++) {
        bool result = winner(players[2 * i], players[2 * i + 1]);
        if (result == 0) {
            auto it = players.erase(players.begin() + (2 * i + 1));
            players.insert(it, null_player);
        }
        else {
            auto it = players.erase(players.begin() + (2 * i));
            players.insert(players.begin() + (2 * i), null_player);
        }
    }
    auto it = players.begin();
    while (it != players.end()) {
        if ((*it) == null_player) {
            it = players.erase(it);
        }
        else {
            ++it;
        }
    }
    return players;
}



int tournament(std::vector<std::pair<std::string, std::multiset<int>>> players) {
    vector<std::pair<std::string, std::multiset<int>>> copied_players;  //copy to get winner id
    copied_players.resize((int)players.size());
    copy(players.begin(), players.end(), copied_players.begin());

    while(players.size() != 1) {
        players = round(players);
    }
    //get ID of winner and return
    auto ir = find(copied_players.begin(), copied_players.end(), players[0]);
    return distance(copied_players.begin(), ir);
}