# lab2

**Task**

1.To achieve a program function, it can extract keywords of different levels from the C or C++ code files that are read in.

2. Write a blog to record your work content and process.

**Work Procedure**

1.Create a GitHub repository for the job.

2.Write the program and commit actively.

3.Iteratively update and optimize the code.

4.Complete your work and write a blog. 

**Program Requirements**

\1. Basic requirement: output "keyword" statistics

\2. Advanced requirement: output the number of "switch case" structures, and output the number of "case" corresponding to each group

\3. Uplifting requirement: output the number of "if else" structures

\4. Ultimate requirement: output the number of "if, else if, else" structures

Before completing the more difficult requirements, you need to complete the Lower requirements.

**Coding Requirements**

1.Use any of C++, Java, Python to complete the work.

2.Develop appropriate code specifications and conduct tests.

3.Use Git for version control.

**Blog Requirements**

1.Give the PSP form for this work.

2.Description of problem-solving ideas. This is the process of how to think and how to find information after getting the title at the beginning.

3.Design and implementation process. The design includes how the code is organized and the flow chart of the key functions.

4.Code description. Show the key code of the project and explain the idea.

5.Unit test screenshots and description.

6.Unit test coverage optimization and performance testing, performance optimization screenshots and descriptions.

7.Summarize this assignment.

**Prerequisites**

**1. github first use** 

In order to ensure that your code can help more people, and can be effectively managed and open source shared, please learn how to use GitHub first:

(1).Download Git.

(2).Learn basic Git commands.

(3).Create a repository on GitHub and upload this assignment, complete the requirements, and make at least 10 commits.

**2. Code specification development**

In order for other colleagues to read your code easily, please formulate your own code specifications and require that they not deviate from the mainstream code specifications: please refer to [alibaba-java-style-guide](https://github.com/chjw8016/alibaba-java-style-guide)/[Google-C++-style-guide](https://zh-google-styleguide.readthedocs.io/en/latest/google-cpp-styleguide/contents/)/[Python PEP8](https://www.python.org/dev/peps/pep-0008/), Develop your programming specifications from the following perspectives and write them into Markdown files. 

\- indentation

\- Variable naming

\- Maximum number of characters per line

\- Maximum number of function lines

\- Function and class naming

\- constant

\- Blank line rule

\- Annotation rules

\- Space before and after operator

\- Other rules

~~~c
1.	#include <stdio.h>  
2.	int main(){  
3.	    int i=1;  
4.	    double j=0;  
5.	    long f;  
6.	    switch(i){  
7.	        case 0:  
8.	            break;  
9.	        case 1:  
10.	            break;  
11.	        case 2:  
12.	            break;  
13.	        default:  
14.	            break;  
15.	    }  
16.	    switch(i){  
17.	        case 0:  
18.	            break;  
19.	        case 1:  
20.	            break;  
21.	        default:  
22.	            break;  
23.	    }  
24.	    if(i<0){  
25.	        if(i<-1){}  22
26.	        else{}  23
27.	    }  
28.	    else if(i>0){  
29.	        if (i>2){}  
30.	        else if (i==2) {}  
31.	        else if (i>1) {}  
32.	        else {}  
33.	    }  
34.	    else{  
35.	        if(j!=0){}  
36.	        else{}  
37.	    }  
38.	    return 0;  
39.	}  

~~~



**Format Requirement**

1.Input format: When executing, you need to pass in two parameters to the program. The first parameter is the path of the code file, and the second parameter is the completion level (from low to high as 1, 2, 3, 4 , if you can complete the uplifting requirement , your level is 3)

\2. Output format: The code above is used as an example

 

**total num: 35**

**switch num: 2**

**case num: 3 2**

**if-else num: 2**

**if-elseif-else num: 2**

 

**Tips:**

\1. TA can’t notice all students. If your blog can impress TA, you can get higher remark.

\2. If you have some question, you should ask directly in the QQ group and you’d better not make a private chat with TAs or tutor.

\3. Please issue your homework in the section of assignment on CSDN.

**4. The Link of each assignment you would accomplish must be submit to Moodle, or you will lose the score of the assignment.**

**5. Each assignment submitted to CSDN must be completed in Engl****ish.**



 
