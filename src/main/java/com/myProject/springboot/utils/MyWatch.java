package com.myProject.springboot.utils;

import org.springframework.util.StopWatch;

import java.text.NumberFormat;

public class MyWatch extends StopWatch {
    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(shortSummary());
        sb.append('\n');
        sb.append("---------------------------------------------\n");
        sb.append("Task name\t\t耗时\t\t\t占比\n");
        sb.append("---------------------------------------------\n");
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);
        NumberFormat pf = NumberFormat.getPercentInstance();
        pf.setMinimumIntegerDigits(2);
        pf.setGroupingUsed(false);
        for (TaskInfo task : getTaskInfo()) {
            sb.append("【" + task.getTaskName()).append("】\t\t");
            sb.append("【" + nf.format(task.getTimeMillis())).append("】ms\t\t");
            sb.append("【" + pf.format((double) task.getTimeNanos() / getTotalTimeNanos())).append("】");
            sb.append('\n');
        }
        sb.append("【" + "结果汇总").append("】\t\t");
        sb.append("【" + nf.format(super.getTotalTimeMillis())).append("】ms\t\t");
        sb.append("【" + "100").append("】");
        sb.append('\n');
        sb.append("---------------------------------------------\n");
        return sb.toString();
    }
}
