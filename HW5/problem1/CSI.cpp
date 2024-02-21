#include <fstream>
#include "CSI.h"
using namespace std;

Complex::Complex(): real(0), imag(0) {}
CSI::CSI(): data(nullptr), num_packets(0), num_channel(0), num_subcarrier(0) {}

CSI::~CSI() {
    if(data) {
        for(int i = 0 ; i < num_packets; i++) {
            delete[] data[i];
        }
        delete[] data;
    }
}

int CSI::packet_length() const {
    return num_channel * num_subcarrier;
}

void CSI::print(std::ostream& os) const {
    for (int i = 0; i < num_packets; i++) {
        for (int j = 0; j < packet_length(); j++) {
            os << data[i][j] << ' ';
        }
        os << std::endl;
    }
}

std::ostream& operator<<(std::ostream &os, const Complex &c) {
    // TODO: problem 1.1
    os << c.real << "+" << c.imag << "i" ;
    return os;
}

void read_csi(const char* filename, CSI* csi) {
    // TODO: problem 1.2
    string str;
    ifstream myFile;
    myFile.open(filename);  //ADD FILE CHECK!!
    if (!myFile) {
        myFile.close();
        return; //file not exist
    }
    //get first three lines
    string n;
    if (getline(myFile, n)) {
        csi->num_packets = stoi(n);
    }
    string m;
    if (getline(myFile, m)) {
        csi->num_channel = stoi(m);
    }
    string k;
    if (getline(myFile, k)) {
        csi->num_subcarrier = stoi(k);
    }

    //initialize 2D array
    Complex** data = new Complex*[csi->num_packets];

    for (int p = 0; p< csi->num_packets; p++) {
        data[p] = new Complex[(csi->num_channel) * (csi->num_subcarrier)];
        for (int i = 0; i < csi->num_subcarrier; i++) {
            for (int j = 0; j < csi->num_channel; j++) {
                Complex complex;
                string a;
                getline(myFile, a);
                complex.real = stoi(a);
                string b;
                getline(myFile, b);
                complex.imag = stoi(b);
                data[p][j * (csi->num_subcarrier) + i ] = complex;
            }
        }
    }

    csi->data = data;
    myFile.close();
}

float** decode_csi(CSI* csi) {
    // TODO: problem 1.3
    int packetsNum = (*csi).num_packets;
    int channelsNum = (*csi).num_channel;
    int subcarriersNum = (*csi).num_subcarrier;

    float** outputArray = new float*[packetsNum];
    for (int p = 0; p< packetsNum; p++) {
        int k = 0;
        outputArray[p] = new float[channelsNum * subcarriersNum];
        for (int i = 0; i<subcarriersNum; i++) {
            for (int j = 0; j<channelsNum; j++) {
                int a = (*csi).data[p][k].real;
                int b = (*csi).data[p][k].imag;
                float f;
                f = sqrt(a*a + b*b);
                outputArray[p][k] = f;
                k++;
            }
        }
    }
    return outputArray;
}

float* get_std(float** decoded_csi, int num_packets, int packet_length) {
    // TODO: problem 1.4
    float* stdArray = new float [num_packets];
    for (int p = 0; p< num_packets; p++) {
        float* data = decoded_csi[p];
        float std = standard_deviation(data, packet_length);
        stdArray[p] = std;
    }

    return stdArray;
}

void save_std(float* std_arr, int num_packets, const char* filename) {
    // TODO: problem 1.5
    ofstream out(filename);
    if (!out.is_open()) {
        return;
    }
    for (int i = 0; i<num_packets; i++) {
        out << std_arr[i] << " ";
    }
    out.flush();
    out.close();
}

// convenience functions
float standard_deviation(float* data, int array_length) {
    float mean = 0, var = 0;
    for (int i = 0; i < array_length; i++) {
        mean += data[i];
    }
    mean /= array_length;
    for (int i = 0; i < array_length; i++) {
        var += pow(data[i]-mean,2);
    }
    var /= array_length;
    return sqrt(var);
}
