//
// Created by Jiwon Kim on 2020/11/28.
//
#include "problem2_2.h"
#include "problem2_3.h"
using namespace std;
// TODO 2-3


const std::string MAXIMIZE_GAIN = "Maximize-Gain";
const std::string MINIMIZE_LOSS = "Minimize-Loss";
const std::string MINIMIZE_REGRET = "Minimize-Regret";

int maximize_gain(std::multiset<int> mySet, std::multiset<int> oppSet) {
    multiset<int>::iterator myIter;
    multiset<int>::iterator oppIter;
    std::multiset<pair<int, int>> myPair;
    for(myIter=mySet.begin(); myIter!=mySet.end(); myIter++) {
        int a = *myIter;
        int maxresult = 0;
        for(oppIter=oppSet.begin(); oppIter!=oppSet.end(); oppIter++) {
            int b = *oppIter;
            if (number_vs_number(a, b).first >= maxresult) {
                maxresult = number_vs_number(a, b).first;
            }
        }
        myPair.insert(std::pair<int, int>(a, maxresult-a));
    }
    multiset<pair<int,int>>::iterator iter;
    int result;
    int maxOutcome = -1*10*10*10*10*10*10;
    for (iter=myPair.begin(); iter!=myPair.end(); iter++) {
        if ((*iter).second > maxOutcome) {
            maxOutcome = (*iter).second;
            result = (*iter).first;
        }
        else if((*iter).second == maxOutcome) {
            if ((*iter).first <= result) {
                result = (*iter).first;
            }
        }
    }
    return result;
}

int minimize_loss(std::multiset<int> mySet, std::multiset<int> oppSet) {
    multiset<int>::iterator myIter;
    multiset<int>::iterator oppIter;
    std::multiset<pair<int, int>> myPair;
    for(myIter=mySet.begin(); myIter!=mySet.end(); myIter++) {
        int a = *myIter;
        int minresult = a;
        for(oppIter=oppSet.begin(); oppIter!=oppSet.end(); oppIter++) {
            int b = *oppIter;
            if (number_vs_number(a, b).first <= minresult) {
                minresult = number_vs_number(a, b).first;
            }
        }
        myPair.insert(std::pair<int, int>(a, minresult - a));
    }
    multiset<pair<int,int>>::iterator iter;
    int result;
    int maxOutcome = -1*10*10*10*10*10*10;
    for (iter=myPair.begin(); iter!=myPair.end(); iter++) {
        if ((*iter).second > maxOutcome) {
            maxOutcome = (*iter).second;
            result = (*iter).first;
        }
        else if((*iter).second == maxOutcome) {
            if ((*iter).first <= result) {
                result = (*iter).first;
            }
        }
    }
    return result;
}

int minimize_regret(std::multiset<int> mySet, std::multiset<int> oppSet) {
    int bestNum = maximize_gain(mySet, oppSet);
    int bestOutcome = -1000;
    multiset<int>::iterator tempIter;
    int temp = 0;
    for(tempIter=oppSet.begin(); tempIter!=oppSet.end(); tempIter++) {
        int b = *tempIter;
        if (number_vs_number(bestNum, b).first >= temp) {
            temp = number_vs_number(bestNum, b).first;
            bestOutcome = temp - bestNum;
        }
    }

    multiset<int>::iterator myIter;
    multiset<int>::iterator oppIter;
    std::multiset<pair<int, int>> myPair;
    for(myIter=mySet.begin(); myIter!=mySet.end(); myIter++) {
        int a = *myIter;
        int minresult = a;
        for(oppIter=oppSet.begin(); oppIter!=oppSet.end(); oppIter++) {
            int b = *oppIter;
            if (number_vs_number(a, b).first <= minresult) {
                minresult = number_vs_number(a, b).first;
            }
        }
        myPair.insert(std::pair<int, int>(a, bestOutcome - minresult + a));
    }
    multiset<pair<int,int>>::iterator iter;
    int result;
    int maxOutcome = 1*10*10*10*10*10*10;
    for (iter=myPair.begin(); iter!=myPair.end(); iter++) {
        if ((*iter).second < maxOutcome) {
            maxOutcome = (*iter).second;
            result = (*iter).first;
        }
        else if((*iter).second == maxOutcome) {
            if ((*iter).first <= result) {
                result = (*iter).first;
            }
        }
    }
    return result;

}


std::pair<std::multiset<int>, std::multiset<int>> player_battle(
        std::string type_a, std::multiset<int> a, std::string type_b, std::multiset<int> b
) {
    int a_number;
    if (type_a == MAXIMIZE_GAIN) {
        a_number = maximize_gain(a, b);
    }
    else if (type_a == MINIMIZE_LOSS){
        a_number = minimize_loss(a, b);
    }
    else {
        a_number = minimize_regret(a, b);
    }

    int b_number;
    if (type_b == MAXIMIZE_GAIN) {
        b_number = maximize_gain(b, a);
    }
    else if (type_b == MINIMIZE_LOSS) {
        b_number = minimize_loss(b, a);
    }
    else {
        b_number = minimize_regret(b, a);
    }
    //MATCH!

    int a_changed = number_vs_number(a_number, b_number).first;
    int b_changed = number_vs_number(a_number, b_number).second;

    multiset<int>::iterator aIter;
    multiset<int>::iterator bIter;
    for(aIter=a.begin(); aIter!=a.end(); aIter++) {
        if ((*aIter) == a_number) {
            a.erase(aIter);
            break;
        }
    }
    a.insert(a_changed);

    for(bIter=b.begin(); bIter!=b.end(); bIter++) {
        if ((*bIter) == b_number) {
            b.erase(bIter);
            break;
        }
    }
    b.insert(b_changed);

    return std::pair<std::multiset<int>, std::multiset<int>>(a, b);
}