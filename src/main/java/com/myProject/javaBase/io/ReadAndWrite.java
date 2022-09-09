package com.myProject.javaBase.io;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWrite {

    @Test
    public void test1() {
        FileWriter file=null;
        try {
            file=new FileWriter("d:\\Demo.txt",false);
            file.write("汉皇重色思倾国，御宇多年求不得。\n" +
                    "杨家有女初长成，养在深闺人未识。\n" +
                    "天生丽质难自弃，一朝选在君王侧。\n" +
                    "回眸一笑百媚生，六宫粉黛无颜色。\n" +
                    "春寒赐浴华清池，温泉水滑洗凝脂。\n" +
                    "侍儿扶起娇无力，始是新承恩泽时。\n" +
                    "云鬓花颜金步摇，芙蓉帐暖度春宵。\n" +
                    "春宵苦短日高起，从此君王不早朝。\n" +
                    "承欢侍宴无闲暇，春从春游夜专夜。\n" +
                    "后宫佳丽三千人，三千宠爱在一身。\n" +
                    "金屋妆成娇侍夜，玉楼宴罢醉和春。\n" +
                    "姊妹弟兄皆列土，可怜光彩生门户。\n" +
                    "遂令天下父母心，不重生男重生女。\n" +
                    "骊宫高处入青云，仙乐风飘处处闻。\n" +
                    "缓歌慢舞凝丝竹，尽日君王看不足。\n" +
                    "渔阳鼙鼓动地来，惊破霓裳羽衣曲。\n" +
                    "九重城阙烟尘生，千乘万骑西南行。\n" +
                    "翠华摇摇行复止，西出都门百余里。\n" +
                    "六军不发无奈何，宛转蛾眉马前死。\n" +
                    "花钿委地无人收，翠翘金雀玉搔头。\n" +
                    "君王掩面救不得，回看血泪相和流。\n" +
                    "黄埃散漫风萧索，云栈萦纡登剑阁。\n" +
                    "峨嵋山下少人行，旌旗无光日色薄。\n" +
                    "蜀江水碧蜀山青，圣主朝朝暮暮情。\n" +
                    "行宫见月伤心色，夜雨闻铃肠断声。\n" +
                    "天旋日转回龙驭，到此踌躇不能去。\n" +
                    "马嵬坡下泥土中，不见玉颜空死处。\n" +
                    "君臣相顾尽沾衣，东望都门信马归。\n" +
                    "归来池苑皆依旧，太液芙蓉未央柳。\n" +
                    "芙蓉如面柳如眉，对此如何不泪垂。\n" +
                    "春风桃李花开夜，秋雨梧桐叶落时。\n" +
                    "西宫南苑多秋草，落叶满阶红不扫。\n" +
                    "梨园弟子白发新，椒房阿监青娥老。\n" +
                    "夕殿萤飞思悄然，孤灯挑尽未成眠。\n" +
                    "迟迟钟鼓初长夜，耿耿星河欲曙天。\n" +
                    "鸳鸯瓦冷霜华重，翡翠衾寒谁与共。\n" +
                    "悠悠生死别经年，魂魄不曾来入梦。\n" +
                    "临邛道士鸿都客，能以精诚致魂魄。\n" +
                    "为感君王辗转思，遂教方士殷勤觅。\n" +
                    "排空驭气奔如电，升天入地求之遍。\n" +
                    "上穷碧落下黄泉，两处茫茫皆不见。\n" +
                    "忽闻海上有仙山，山在虚无缥渺间。\n" +
                    "楼阁玲珑五云起，其中绰约多仙子。\n" +
                    "中有一人字太真，雪肤花貌参差是。\n" +
                    "金阙西厢叩玉扃，转教小玉报双成。\n" +
                    "闻道汉家天子使，九华帐里梦魂惊。\n" +
                    "揽衣推枕起徘徊，珠箔银屏迤逦开。\n" +
                    "云鬓半偏新睡觉，花冠不整下堂来。\n" +
                    "风吹仙袂飘飖举，犹似霓裳羽衣舞。\n" +
                    "玉容寂寞泪阑干，梨花一枝春带雨。\n" +
                    "含情凝睇谢君王，一别音容两渺茫。\n" +
                    "昭阳殿里恩爱绝，蓬莱宫中日月长。\n" +
                    "回头下望人寰处，不见长安见尘雾。\n" +
                    "惟将旧物表深情，钿合金钗寄将去。\n" +
                    "钗留一股合一扇，钗擘黄金合分钿。\n" +
                    "但令心似金钿坚，天上人间会相见。\n" +
                    "临别殷勤重寄词，词中有誓两心知。\n" +
                    "七月七日长生殿，夜半无人私语时。\n" +
                    "在天愿作比翼鸟，在地愿为连理枝。\n" +
                    "天长地久有时尽，此恨绵绵无绝期。");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test2() {
        FileReader file= null;
        try {
            file = new FileReader("d:\\Demo.txt");
            int num=0;
            char [] buf=new char[1024];
            while((num=file.read(buf))!=-1)
            {
                System.out.println(new String(buf,0,num));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
