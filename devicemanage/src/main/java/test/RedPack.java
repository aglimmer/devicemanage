package test;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedPack {
    // 红包总金额
    public static double money;
    // 红包总数
    public static int sumNum = 0;
    // 已抢的红包数
    public static int num;
    // 发红包的开始时间:毫秒数 1970 00:00:00 至今的毫秒数
    public static long start;
    // 红包有效时间:1天
    public static long endTime = 86400000;
    // 使用一个类似数组的数据结构 存储已经被抢到的红包金额
    public static List<Double> array = new ArrayList<>();
    // 使用一个类似数组的数据结构 存储已经抢到的用户名
    public static List<String> nameArray = new ArrayList<>();
    // 运气王用户名
    public static String maxLuckyPerson = null;
    // 运气王钱数
    public static double maxLucky = 0;
    // 表示状态的属性 0:未发出 1:已发出
    public static int isSend = 0;

    private static Logger logger = LoggerFactory.getLogger(RedPack.class);

    // 发红包:老板
    public static void sendRedPack(double packMoney, int packNum) {
        // 发红包之前 需要重置红包
        initRedPack();
        // 设置红包的总金额以及红包总数分别为传入的两个参数值
        RedPack.money = packMoney;
        RedPack.sumNum = packNum;
        // 使用Java生成随机数的工具类
        Random r = new Random();
        double sum = 0;
        
        double d = 3.1415926;
//      String result = String .format("%.2f",d);
//      System.out.println("RedPack.sendRedPack()="+Double.valueOf(String .format("%.2f",d)));
        double temp = 0;
        for (int i = 0; i < packNum; i++) {
            // 经过小小的计算 使得最小的钱尽量接近0.01
        
        	temp = r.nextDouble() * packMoney + 0.01 * packNum * packMoney;
//        	格式化为2位小数
        	temp = Double.valueOf(String.format("%.2f",temp));
            RedPack.array.add(temp);
        	
        	
        }
        double sendMoney = 0;
        // TODO:如何限制随机生成的数 总和刚好等于红包总数 并且小数位限制为两位
        for (int i = 0; i < packNum; i++) {
        	temp = RedPack.array.get(i);
        	sum += temp;
        	if(sum<=RedPack.money) {
        		logger.info(""+RedPack.array.get(i));
//        		System.out.println(RedPack.array.get(i));
        		sendMoney += RedPack.array.get(i);
        	}else {
        		if(sendMoney<RedPack.money) {
                 	double remain = Double.valueOf(String.format("%.2f",RedPack.money-sendMoney));
                 	sendMoney += remain;
//                 	System.out.println(remain);
                 	logger.info(""+remain);
                 	continue;
                }
        		logger.info(""+0.00);
//        		System.out.println(0.00);
        		
        	}
        	
        	
        	
        }
       logger.info("发出总数："+sendMoney);
//        System.out.println("发出总数："+sendMoney);
       
    }
    
    // 抢红包:用户

    // 初始化红包/重置红包
    public static void initRedPack() {
    	logger.info("\"正在重置红包:\"");
//        System.out.println("正在重置红包:");
        RedPack.money = 0;
        RedPack.sumNum = 0;
        RedPack.num = 0;
        RedPack.maxLucky = 0;
        RedPack.maxLuckyPerson = null;
        RedPack.start = 0;
        RedPack.endTime = 86400000;
        RedPack.isSend = 0;
        RedPack.nameArray.clear();
        RedPack.array.clear();
    }

    public static void main(String[] args) {
        sendRedPack(15, 5);
    }

}

