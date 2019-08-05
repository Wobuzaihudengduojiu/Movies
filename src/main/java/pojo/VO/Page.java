package pojo.VO;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private int pageNum = 0;

    private int pageSize = 10;

    private int total;

    private int pages;

    private List<T> list;

    public Page(List<T> dataList, int pageNum, int pageSize) {


        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = dataList.size();
        this.list = getData(dataList);
        this.pages = getPageNumber();

    }

    public Page() {
    }

    private int getPageNumber() {
        int num = 0;

        if (pageSize >= total) {
            num = 1;
        } else {
            num = total / pageSize;
            num += (total % pageSize) == 0 ? 0 : 1;
        }
        return num;
    }


    private List<T> getData(List<T> data) {

        if (total != 0) {

            int head = Math.min(Math.max(pageSize * (pageNum - 1), 0), data.size());
            int tail = Math.min(Math.max(pageSize * pageNum, head), data.size());

            return data.subList(head, tail);

        }

        return data;

    }


}
