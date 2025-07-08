/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Employee> hm; 
    public int importance(Employee e){
        int i=e.importance;
        List<Integer> list=e.subordinates;
        for(int k:list){
            i=i+importance(hm.get(k));
        }
        return i; 
    }
    public int getImportance(List<Employee> employees, int id) {
        hm=new HashMap<>();
        for(Employee emp:employees)
        hm.put(emp.id,emp);
        return importance(hm.get(id));
    }
}