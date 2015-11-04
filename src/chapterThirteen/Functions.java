package chapterThirteen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Functions {
    
    //example form book
    public static List<List<Integer>> subsets(List<Integer> list){
        //add empty list
        if(list.isEmpty()){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        
        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);     
    }
    
    //my own
    public static List<Integer> insert(Integer num, List<Integer> list){
        if(list.isEmpty()){
            List<Integer> ans = new ArrayList<>();
            ans.add(num);
            return ans;
        }
        
        Integer first = list.get(0);
        if(num < first){
            return cons(num, list);
        }
        
        if(num == first){
            return list;
        }
        
        List<Integer> rest = list.subList(1,  list.size());
        List<Integer> subans = insert(num, rest);
        List<Integer> subans2 = cons(first, subans);
        return concat2(subans, subans2);
    }
    
    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans){
        List<List<Integer>> result = new ArrayList<>();
        
        for(List<Integer> l : subans){
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(l);
            result.add(copyList);
        }
        
        return result;
    }
    private static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subans2){
        List<List<Integer>> concat = new ArrayList<>(subans);
        concat.addAll(subans2);
        return concat;
    }
    private static List<Integer> concat2(List<Integer> l1, List<Integer> l2){
        List<Integer> concat = new ArrayList<>(l1);
        if(l2.size() > 0){
            concat.add(0, l2.get(0));
        }
        return concat;
    }
    
    //add item to a list
    private static <T> List<T> cons(T item, List<T> list){
        List<T> result = new ArrayList<T>();
        result.add(item);
        result.addAll(list);
        return result;
    }
}
