package com.company;

public class URLDepthPair {
    
    private String URL;
    private int depth;

    public void setURL(String URL) { this.URL = URL; }
    public void setDepth(int depth) { this.depth = depth; }

    public int getDepth()  { return depth; }
    public String getURL() { return URL; }

    public URLDepthPair(String URL, int depth){
        this.URL = URL;
        this.depth = depth;
    }

    public String toString() {
        return "depth: " + depth + " URL: ["+ URL + "]";
    }
}