/**
 *
 * You are given a data structure of employee information, which includes
 * the employee's unique id, their importance value and their direct
 * subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2, and employee 2 is
 * the leader of employee 3. They have importance value 15, 10 and 5, respectively.
 * Then employee 1 has a data structure like [1, 15, [2]], and employee 2
 * has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3
 * is also a subordinate of employee 1, the relationship is not direct.
 *
 * Now given the employee information of a company, and an employee id,
 * you need to return the total importance value of this employee and all their subordinates.
 *
 *  Definition for Employee.
 *  class Employee {
 *  public int id;
 *  public int importance;
 *  public List<Integer> subordinates;
 *  };
 * @author anitgeorge
 */

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {

        if(employees.isEmpty())
            return 0;
        Map<Integer, Employee> map = new HashMap<>();
        Set<Integer> set           = new HashSet<>();
        Queue<Employee> queue      = new LinkedList<>();
        int result = 0;
        for(Employee emp : employees)
            map.put(emp.id, emp);
        queue.offer(map.get(id));
        set.add(id);
        while(!queue.isEmpty()){

            Employee emp = queue.poll();
            result += emp.importance;
            for(int sub : emp.subordinates)
                if(!set.contains(sub)){
                    queue.offer(map.get(sub));
                    set.add(sub);
                }
        }
        return result;
    }
}
