//
// Created by Jiwon Kim on 2020/11/28.
//
#include "problem2_2.h"
//#include <math.h>

using namespace std;
// TODO 2-2

std::pair<int, int> number_fight(int a, int b);
std::multiset<int> factorize(int num);

std::pair<int, int> attack(int attacker, int victim) {
    int D;
    std::pair<int, int> fightIf = number_fight(attacker, victim);
    D = victim - fightIf.second;
    multiset<int> FVictim;
    FVictim = factorize(victim);

    multiset<int>::iterator iter = FVictim.find(7);
    if (iter != FVictim.end()) {
        int a = floor(attacker - D/2);
        int b = floor(victim - D/2);
        if (a<1) {
            a = 1;
            floor
        }
        if (b<1) {
            b = 1;
        }
        return std::pair<int, int> (a,b);
    }

    return std::pair<int, int> (attacker, victim - D);
}


bool decisionFight(int maker, int opp) {
    //opp will fight
    std::pair<int, int> O_Fight_M_Fight = number_fight(maker, opp);
    std::pair<int, int> temp = attack(opp, maker);
    int a = temp.first;
    int b = temp.second;
    std::pair<int, int> O_Fight_M_No = {b, a};

    string C_O_Fight;
    if (O_Fight_M_Fight.first >= O_Fight_M_No.first) {
        C_O_Fight = "fight";
    }
    else {
        C_O_Fight = "not fight";
    }

    //opp will not fight
    std::pair<int, int> O_No_M_Fight = attack(maker, opp);
    std::pair<int, int> O_NO_M_NO = {maker, opp};

    string C_O_No;
    if (O_No_M_Fight.first >= O_NO_M_NO.first) {
        C_O_No = "fight";
    }
    else {
        C_O_No = "not fight";
    }

    if (C_O_Fight == C_O_No) {
        if (C_O_Fight == "fight") {return 1;}
        else {return 0;}
    }
    else {
        if (opp > maker) {return 1;}
        else {return 0;}
    }

}


std::pair<int, int> number_vs_number(int a, int b) {
    bool a_decision = decisionFight(a, b);
    bool b_decision = decisionFight(b, a);
    if (a_decision && b_decision) {
        return number_fight(a, b);
    }
    else if (!a_decision && b_decision) {
        std::pair<int, int> temp = attack(b, a);
        int first = temp.first;
        int second = temp.second;
        return std::pair<int, int> (second, first);
    }
    else if (a_decision && !b_decision) {
        return attack(a, b);
    }
    else {
        return std::pair<int, int> (a,b);
    }

}




