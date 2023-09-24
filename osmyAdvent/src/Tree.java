public class Tree {
    private int height;
    private int row;
    private int column;
    private int viewDistance;
    private boolean visible = false;

    public Tree(int height, int row, int column, int viewDistance, boolean visible) {
        this.height = height;
        this.row = row;
        this.column = column;
        this.viewDistance = viewDistance;
        this.visible = visible;
    }

    public int getHeight() {
        return height;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public void setViewDistance(int viewDistance) {
        this.viewDistance = viewDistance;
    }
}
