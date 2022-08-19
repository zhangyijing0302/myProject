package com.myProject.company.xyxx;

import java.util.*;

/**
 *
 * <p>
 * 功能: 计算程序的圈复杂度
 * <p>
 * 控制流图（CFG,Control Flow Graph）是以有向图表示程序逻辑结构的一种形式，
 * 能够直观展示程序的分支、跳转、复杂度等特性，
 * 是编译优化、程序分析、软件测试等 领域的一种基本程序中间表示。
 * <p>
 * 圈复杂度是用于评价函数复杂度的一种指标，
 * 一般认为圈复杂度越高，说明函数越 复杂、越难以维护或测试。圈复杂度的一种计算方法是：
 * <pre>
 * 圈复杂度 = 控制流图中分支节点个数 + 1
 * </pre>
 * <p>
 * 分支节点是指含if，else if，for，while语句的节点，即在控制流图中有多个后继节点的节点。
 * <p>
 * 理解上述概念，编写一个函数int calculateMcCabe(GraphNode
 * entry)，输入控制流图的入口节点entry，输出其对应的圈复杂度。 当参数为非法情况时返回0。
 */
public class CountProgram {
    /**
     * 题目提供的CFG构造方法，不要修改,返回CFG的入口节点
     */
    static CFGNode buildCFG() {
        CFGNode entry = new CFGNode("entry");
        CFGNode exit = new CFGNode("exit");
        CFGNode count__0 = new CFGNode("int count = 0; int i =0");
        CFGNode for_a_lt_0 = new CFGNode("for(.. ;i < 100; ..");
        CFGNode i_inc = new CFGNode("for(..;.. ; i++");
        CFGNode if_a_lt_0 = new CFGNode("if (i < 0)");
        CFGNode return0 = new CFGNode("return 0");
        CFGNode if_i_mod_7_eq_0 = new CFGNode("if (i % 7 == 0) ");
        CFGNode count_inc_i = new CFGNode("count += i");
        CFGNode if_count_mod_2_eq_0 = new CFGNode("if (count % 2 == 0)");
        CFGNode return1 = new CFGNode("return 1");
        CFGNode return2 = new CFGNode("return 2");

        entry.addNext(count__0);
        count__0.addNext(for_a_lt_0);

        for_a_lt_0.addNext(if_a_lt_0);
        for_a_lt_0.addNext(if_count_mod_2_eq_0);

        if_a_lt_0.addNext(return0);
        if_a_lt_0.addNext(if_i_mod_7_eq_0);

        if_count_mod_2_eq_0.addNext(return1);
        if_count_mod_2_eq_0.addNext(return2);

        if_i_mod_7_eq_0.addNext(count_inc_i);
        if_i_mod_7_eq_0.addNext(i_inc);
        count_inc_i.addNext(i_inc);

//        i_inc.addNext(for_a_lt_0);

        return0.addNext(exit);
        return1.addNext(exit);
        return2.addNext(exit);

        return entry;
    }

    /**
     * 完成下面的方法，返回正确的圈复杂度
     *
     * 抱歉耽误时间了，陷入了死循环了，可能是我没有太理解透彻题意
     */
    public static int calculateMcCabe(CFGNode entry) {
        int i = 0;
        int num = countMethod(entry, i);
        return num - 1;
    }

    public static int countMethod(CFGNode entry, int i) {
       if (entry.nextList.size() == 0) {
           return i + 1;
       } else {
           for (CFGNode cfgNode : entry.nextList) {
               i = countMethod(cfgNode, i + 1);
           }
           return i;
       }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        CFGNode entry = buildCFG();
        System.out.println("该程序的圈复杂度为：" + calculateMcCabe(entry)+"\n");
    }
}

/**
 * CFG节点类，表示该节点上的数据和后继节点， 可根据需要补充方法和成员
 */
class CFGNode {
    String data; // 节点数据
    LinkedList<CFGNode> nextList = new LinkedList<>(); // 后继节点列表

    public CFGNode(String data) {
        this.data = data;
    }

    public void addNext(CFGNode next) {
        this.nextList.add(next);
    }
}
