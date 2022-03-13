import java.util.Map;

/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<String>();
        Map<String,Integer> map = new HashMap();

        for (int i=0;i<cpdomains.length;i++) {
            String str = cpdomains[i];
            int count = Integer.parseInt(str.split(" ")[0]);
            String temp = str.split(" ")[1];
            String[] splitStr = temp.split("\\.");
            String name = "";
            for(int j=splitStr.length-1;j>=0;j--) {
                if(j == splitStr.length-1) {
                    name = splitStr[j] + name;
                } else {
                    name = splitStr[j]+"."+name;
                }
                int n = map.getOrDefault(name,0)+count;
                map.put(name,n);
            }
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
           String str =  entry.getValue() + " " + entry.getKey();
           ans.add(str);
        }
        return ans;
    }
}
// @lc code=end

