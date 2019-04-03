/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class HeapNode {
    private int cityNum;
    private int distToNext;

    public HeapNode(int cityNum, int distToNext) {
        this.cityNum = cityNum;
        this.distToNext = distToNext;
    }

    public int getCityNum() {
        return cityNum;
    }

    public void setCityNum(int cityNum) {
        this.cityNum = cityNum;
    }

    public int getDistToNext() {
        return distToNext;
    }

    public void setDistToNext(int distToNext) {
        this.distToNext = distToNext;
    }
}
