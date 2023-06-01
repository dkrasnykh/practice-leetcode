package linked_list.design_browser_history_1472;

class ListNode {
    String url;
    ListNode prev;
    ListNode next;

    ListNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

public class BrowserHistory {
    private ListNode curr;

    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage);
    }

    public void visit(String url) {
        ListNode tmp = curr;
        curr.next = new ListNode(url);
        curr = curr.next;
        curr.prev = tmp;
    }

    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps -= 1;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while(steps > 0 && curr.next != null){
            curr = curr.next;
            steps -= 1;
        }
        return curr.url;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}
