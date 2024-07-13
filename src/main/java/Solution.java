import java.util.*;

public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> res = new ArrayList<>();
        int n = positions.length;
        int[][] phd = new int[n][4];
        List<int[]> preRes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            phd[i][0] = positions[i];
            phd[i][1] = healths[i];
            phd[i][2] = directions.charAt(i) == 'L' ? 1 : 0;
            phd[i][3] = i;
        }
        Arrays.sort(phd, Comparator.comparingInt((int[] a) -> a[0]));
        Deque<int[]> toLeft = new ArrayDeque<>();
        Deque<int[]> toRight = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(phd[i][2] == 1) {
                toLeft.push(phd[i]);
                while(!toRight.isEmpty() && !toLeft.isEmpty()) {
                    if(toLeft.peek()[1] == toRight.peek()[1]) {
                        toLeft.pop();
                        toRight.pop();
                    }else if(toLeft.peek()[1] > toRight.peek()[1]){
                        toRight.pop();
                        toLeft.peek()[1]--;
                    }else {
                        toLeft.pop();
                        toRight.peek()[1]--;
                    }
                }
                while(!toLeft.isEmpty()) {
                    int[] t = toLeft.poll();
                    preRes.add(new int[]{t[1],t[3]});
                }
            }else {
                toRight.push(phd[i]);
                while(!toRight.isEmpty() && !toLeft.isEmpty()) {
                    if(toLeft.peek()[1] == toRight.peek()[1]) {
                        toLeft.pop();
                        toRight.pop();
                    }else if(toLeft.peek()[1] > toRight.peek()[1]){
                        toRight.pop();
                        toLeft.peek()[1]--;
                    }else {
                        toLeft.pop();
                        toRight.peek()[1]--;
                    }
                }

            }
        }
        while (!toRight.isEmpty()) {
            int[] t = toRight.poll();
            preRes.add(new int[]{t[1],t[3]});
        }
        Collections.sort(preRes, Comparator.comparingInt((int[] a) -> a[1]));
        for (int[] a : preRes) {
            res.add(a[0]);
        }
        return res;
    }
}
