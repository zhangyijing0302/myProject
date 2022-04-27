package com.randomProject.company.xyxx;

/**
 * 功能: 编写一个程序,在运行时触发StackOverflow
 */
public class StackOverflowCase {

    /**
     * 答复
     */
    public void answer() {
        otherAnswer();
    }

    /**
     * 另一个答复
     */
    public void otherAnswer() {
        answer();
    }

    public static void main(String[] args) {
        StackOverflowCase d = new StackOverflowCase();
        d.answer();
    }

}
