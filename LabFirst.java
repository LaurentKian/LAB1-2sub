import java.io.*;
import java.util.Stack;


/**
 * @author LiZheng.
 * @date 2022/10/22
 */

//开始的时候我使用的是根据空格分段，但是这样的话就会极大地依赖当前的文档，鲁棒性差，代码量还多
public class LabFirst {
    public static void main(String[] args) {
        int totalNum = 0;
        int switchNum = 0;
        int caseNum = 0;
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = "C:\\Users\\10375\\OneDrive - Maynooth University\\大三上\\软件工程\\实验\\实验代码\\lab1-2\\sample.c";
        File file = new File(fileName);
        FileReader fr = null;

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
            // 一行一行地处理...
            String[] spString = line.split("\\s+");
            for (int i = 0; i < spString.length; i++) {
                if (spString[i].equals("int") || spString[i].equals("double") || spString[i].equals("long")) {
                    totalNum++;

                } else if (spString[i].equals("switch(i){")) {
                    if (caseNum != 0) {
                        stringBuilder.append(caseNum);
                        stringBuilder.append(" ");

                    }
                    totalNum++;
                    caseNum = 0;
                    switchNum++;

                } else if (spString[i].equals("case")) {
                    totalNum++;
                    caseNum++;

                } else if ((spString[i].equals("if")) || spString[i].equals("if(i<0){") || spString[i].equals("if(i<-1){}") || spString[i].equals("if(j!=0){}") || spString[i].equals("if(i>0){")) {
                    totalNum++;
                    stack.push("if");

                } else if (spString[i].equals("else") || spString[i].equals("else{}") || spString[i].equals("else{")) {
                    totalNum++;
                    if ((i + 1 < spString.length) && (spString[i + 1].equals("if") || spString[i + 1].equals("if(i>0){"))) {
                        stack.push("else if");
                        totalNum++;
                        i++;
                    } else {
                        stack.push("else");
                    }
                } else if (spString[i].equals("return")) {
                    totalNum++;
                } else if (spString[i].equals("break;") || spString[i].equals("default:")) {
                    totalNum++;
                }

            }

        }

        if (caseNum != 0) {
            stringBuilder.append(caseNum);
            stringBuilder.append(" ");
        }
        System.out.println("total num: " + totalNum);
        System.out.println("switch num: " + switchNum);
        System.out.println("case num: " + stringBuilder);
        processElse(stack);



    }

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
        System.out.println("if-else num: "+ifElseNum);
        System.out.println("if-else num: "+ifElseIfNum);
    }

}
