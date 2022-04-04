package com.designmode.v_state;

import com.designmode.v_state.v2.MM;
import com.designmode.v_state.v2.MMHappyState;
import com.designmode.v_state.v2.MMNervousState;
import com.designmode.v_state.v2.MMState;

/**
 * 状态模式-根据不同的状态做出不同的行为
 */
public class Main {
    public static void main(String[] args) {
        MMState s1 = new MMHappyState();
        MMState s2 = new MMNervousState();

        MM m1 = new MM("m1", s1);
        MM m2 = new MM("m2", s2);

        m1.say();
        m2.say();
    }
}
