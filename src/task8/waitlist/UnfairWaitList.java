package task8.waitlist;

import java.util.*;


public class UnfairWaitList<E> extends WaitList<E> {

    public UnfairWaitList() {
    }

    public void remove(E element){
        //If this element is the first, it should be moved to back
        if (element.equals(content.peek())){
            moveToBack();
            return;
        }

        //Else try to find this element it queue
        Queue<E> elements = new ArrayDeque<>();

        int contentSize = content.size();
        for (int i = 0; i < contentSize; i++){
            E current = content.remove();
            if (!current.equals(element)) {
                content.add(current);
            }
        }

    }

    private void moveToBack(){
        E firstElement = content.remove();
        Queue<E> elements = new ArrayDeque<>();
        while(!content.isEmpty()){
            elements.add(content.remove());
        }
        content.addAll(elements);
        content.add(firstElement);

    }

}
