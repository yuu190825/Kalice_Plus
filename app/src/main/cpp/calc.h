#ifndef KALICEPLUS_CALC_H
#define KALICEPLUS_CALC_H

#include <string>

using std::string;

class Calc {
    // Variable
    bool setAB;
    bool mySetValue;
    bool operandChange;
    bool myFinish;
    bool myError;
    int myOperator;
    int oouControl;
    int dotControl;
    string myA;
    string myB;
    string myM;

    // Basic Function
    string myShow();
    string cStringFormat(string myString);
    string myExecution(string myCommand);
    void myReset();

public:
    // init
    Calc();

    // Control Function
    void setOouControl(int myValue);
    string setDotControl(int myValue);
    string myClear();
    string myNegative();
    string backSpace();
    string memoryRead();
    void memoryWrite();
    string powTwo();
    string mySqrt();
    string sendNumber(string mySend);
    string sendOperator(int mySend);
    string sendDot();
    string getResult();
};

#endif //KALICEPLUS_CALC_H
