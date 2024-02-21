//
// Created by Jiwon Kim on 2020/11/29.
//

#include "problem2_4.h"
using namespace std;
// TODO 2-4

bool compareSets (std::multiset<int> a, std::multiset<int> b) {
    multiset<int>::iterator aIter;
    multiset<int>::iterator bIter;

    if (a.size() != b.size()) {
        return false;
    }
    bIter = b.begin();
    for(aIter=a.begin(); aIter!=a.end(); aIter++) {
        int a = *aIter;
        for( ; bIter!=b.end(); ) {
            int b = *bIter;
            if (a != b) { return false;}
            else {
                bIter++;
                break;
            }
        }
    }
    return true;
}

std::pair<std::multiset<int>, std::multiset<int>> player_vs_player(
        std::string type_a, std::multiset<int> a, std::string type_b, std::multiset<int> b
) {
    multiset<int> a_temp;
    multiset<int> b_temp;

    while(1) {
        a_temp = player_battle(type_a, a, type_b, b).first;
        b_temp = player_battle(type_a, a, type_b, b).second;

        if ( compareSets(a_temp, a) && compareSets(b_temp, b)) {
            break;
        }
        else {
            a = a_temp;
            b = b_temp;
        }
    }
    return std::pair<std::multiset<int>, std::multiset<int>>(a, b);
}
