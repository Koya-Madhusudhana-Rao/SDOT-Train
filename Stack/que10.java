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