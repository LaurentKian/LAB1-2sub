import java.io.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiZheng. 832002125
 * @date 2022/10/22
 */

//使用正则表达的方式可以极大地简化代码，并且增加了广泛的适应性
public class lab1_2final {
    public static void main(String[] args) {
        int totalNum = 0;
        int switchNum = 0;
        int caseNum = 0;
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        //The file path文件路径
        String fileName = "C:\\Users\\10375\\OneDrive - Maynooth University\\大三上\\软件工程\\实验\\实验代码\\lab1-2\\sample.c";
        //completion level is 4，完成全部任务
        File file = new File(fileName);
        FileReader fr = null;

        //we use Regular expression to find the target world正则表达
        String intP = ".*int.*";
        String doubleP = ".*double.*";
        String longP = ".*long.*";
        String switchP = ".*switch.*";
        String caseP = ".*case.*";
        String returnP = ".*return.*";
        String breakP = ".*break.*";
        String defaultP = ".*default.*";
        String ifP = ".*if.*";
        String elseP = ".*else.*";
        String elseIfP = ".*else if.*";

        //compile the Regular expression
        Pattern intR = Pattern.compile(intP);
        Pattern doubleR = Pattern.compile(doubleP);
        Pattern longR = Pattern.compile(longP);
        Pattern switchR = Pattern.compile(switchP);
        Pattern caseR = Pattern.compile(caseP);
        Pattern returnR = Pattern.compile(returnP);
        Pattern breakR = Pattern.compile(breakP);
        Pattern defaultR = Pattern.compile(defaultP);
        Pattern ifR = Pattern.compile(ifP);
        Pattern elseR = Pattern.compile(elseP);
        Pattern elseIfR = Pattern.compile(elseIfP);


        //find the context of the file，一行行的读文章代码
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //make the match for each line，match正则表达
            Matcher intRM = intR.matcher(line);
            Matcher doubleRM = doubleR.matcher(line);
            Matcher longRM = longR.matcher(line);
            Matcher switchRM = switchR.matcher(line);
            Matcher caseRM = caseR.matcher(line);
            Matcher returnRM = returnR.matcher(line);
            Matcher breakRM = breakR.matcher(line);
            Matcher defaultRM = defaultR.matcher(line);
            Matcher ifRM = ifR.matcher(line);
            Matcher elseRM = elseR.matcher(line);
            Matcher elseIfRM = elseIfR.matcher(line);

            if (intRM.find() || doubleRM.find() || longRM.find()) {
                totalNum++;

            } else if (switchRM.find()) {

                if (caseNum != 0) {
                    stringBuilder.append(caseNum);
                    stringBuilder.append(" ");
                }
                totalNum++;
                caseNum = 0;
                switchNum++;

            } else if (caseRM.find()) {
                totalNum++;
                caseNum++;

            } else if (elseIfRM.find()) {
                stack.push("else if");
                totalNum += 2;

            } else if (ifRM.find()) {
                totalNum++;
                stack.push("if");

            } else if (elseRM.find()) {
                stack.push("else");
                totalNum++;

            } else if (returnRM.find() || breakRM.find() || defaultRM.find()) {
                totalNum++;
            }
        }

//      用来计算两个switch下面的case数量
        if (caseNum != 0) {
            stringBuilder.append(caseNum);
            stringBuilder.append(" ");
        }

        System.out.println("total num: " + totalNum);
        System.out.println("switch num: " + switchNum);
        System.out.println("case num: " + stringBuilder);

        processElse(stack);

    }

    //process the if-else and if-elseif-else，处理if else-if else和 if else问题
    public static void processElse(Stack<String> stack) {
        int ifElseNum = 0;
        int ifElseIfNum = 0;
        Stack<String> res = new Stack<String>();
        boolean flag = false;
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            if (temp.equals("else")) {
                res.push(temp);
            } else if (temp.equals("else if")) {
                res.push(temp);
            } else {//if
                while (res.peek().equals("else if")) {
                    res.pop();
                    flag = true;
                }
                if (res.peek().equals("else")) {
                    res.pop();
                }
                if (flag) {
                    ifElseIfNum++;
                    flag = false;
                } else {
                    ifElseNum++;
                }


            }
        }
        System.out.println("if-else num: " + ifElseNum);
        System.out.println("if-else num: " + ifElseIfNum);
    }



}
