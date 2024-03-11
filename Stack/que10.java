// COURSE SCHEDULE
// You are given a number N, the number of courses you have to take labeled from 0 t N-1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must 
// take course bi first if you want to take course ai.

// eg: [2,4] means take course 4 before you can take course 2.
// Input
// The First line of input number of courses (N).
// The Second line of input size of prerequisites array (M)
// Next line contains two integer each denoting ai and bi.
// Output
// print 1 if it is possible to finish all the courses else print 0.
// Example
// Input:

// 5
// 4
// 1 0
// 2 1
// 3 2
// 4 3
// Output:

// 1


//10


import java.util.*;
class Main{
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            list.get(preCourse).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            count++;

            for(int neighbor : list.get(currentCourse)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return (count==numCourses);
    }
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] aibi = new int[m][2];

        for(int i = 0; i < m; i++){
            aibi[i][0] = sc.nextInt();
            aibi[i][1] = sc.nextInt();
        }

        Main newMain = new Main();
        if(newMain.canFinish(n, aibi)){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
	}
}