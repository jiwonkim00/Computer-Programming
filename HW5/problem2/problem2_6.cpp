//
// Created by Jiwon Kim on 2020/12/01.
//

#include "problem2_6.h"
using namespace std;
// TODO 2-6

int steady_winner(std::vector<std::pair<std::string, std::multiset<int>>> players) {
//    vector<std::pair<std::string, std::multiset<int>>> copied_players;  //copy to get winner id
//    copied_players.resize((int)players.size());
//    copy(players.begin(), players.end(), copied_players.begin());
    int scores[16] = {0,};

    for (int i = 0; i<players.size(); i++) {
        int winner = tournament(players);
        int winner_id;
        //find real winner id
        if (winner + i >= players.size()) {
            winner_id = winner - ((int)players.size() - i);
        }
        else {
            winner_id = winner + i;
        }

        scores[winner_id] += 1;
        auto ir = players.begin();
        player copied = players[0];
        players.erase(ir);
        players.push_back(copied);
    }
    //determine the steady winner
    int max = -1;
    int steady_winner = -1;
    for (int i = 0; i<players.size(); i++) {
        if (scores[i] > max) {
            max = scores[i];
            steady_winner = i;
        }
    }
    return steady_winner;
}