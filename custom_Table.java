/*
custom table
draggable,multi-selectable
*/

public class TableAdapter {

    public TableAdapter(Context mContext, final TableLayout Table, ArrayList<> dataList, final CheckBox box) {
        Table.removeAllViews();
        clickRow column = new clickRow(mContext);
        column.setBackgroundColor(Color.parseColor("#000000"));

        final Cell_Attr Text1 = new Cell_Attr(mContext,"Text",true);
        final Cell_Attr Text2 = new Cell_Attr(mContext,"Text",true);
        final Cell_Attr Text3 = new Cell_Attr(mContext,"Text",true);
        final Cell_Attr Text4 = new Cell_Attr(mContext,"Text",true);
        final Cell_Attr Text5 = new Cell_Attr(mContext,"Text",true);
        final Cell_Attr Text6 = new Cell_Attr(mContext,"Text",true);
        final Cell_Attr Text7 = new Cell_Attr(mContext,"Text",true);
        final Cell_Attr Text8 = new Cell_Attr(mContext,"Text",true);

        column.addView(Text1);
        column.addView(Text2);
        column.addView(Text3);
        column.addView(Text4);
        column.addView(Text5);
        column.addView(Text6);
        column.addView(Text7);
        column.addView(Text8);

        Table.addView(column);

        for (int i = 0; i < arSM.size(); i++) {
            final clickRow row = new clickRow(mContext);
            row.setBackgroundColor(Color.parseColor("#000000"));

            final Cell_Attr Text1 = new Cell_Attr(mContext,"Text",false);
            final Cell_Attr Text2 = new Cell_Attr(mContext,"Text",false);
            final Cell_Attr Text3 = new Cell_Attr(mContext,"Text",false);
            final Cell_Attr Text4 = new Cell_Attr(mContext,"Text",false);
            final Cell_Attr Text5 = new Cell_Attr(mContext,"Text",false);
            final Cell_Attr Text6 = new Cell_Attr(mContext,"Text",false);
            final Cell_Attr Text7 = new Cell_Attr(mContext,"Text",false);
            final Cell_Attr Text8 = new Cell_Attr(mContext,"Text",false);

            column.addView(Text1);
            column.addView(Text2);
            column.addView(Text3);
            column.addView(Text4);
            column.addView(Text5);
            column.addView(Text6);
            column.addView(Text7);
            column.addView(Text8);

            View.OnClickListener Click_row = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ColorDrawable cd = (ColorDrawable) row.getChildAt(0).getBackground();
                    int colorCode = cd.getColor();
                    if(colorCode== -1) {
                        for(int cnt=0;cnt<row.getChildCount();cnt++){
                            row.getChildAt(cnt).setBackgroundResource(R.color.colorSelect);
                        }
                        row.setCheck(true);
                    }else{
                        for(int cnt=0;cnt<row.getChildCount();cnt++){
                            row.getChildAt(cnt).setBackgroundResource(R.color.table_white);
                        }
                        row.setCheck(false);
                    }
                    int check=0;
                    for (int cnt = 1; cnt < Table.getChildCount(); cnt++) {
                        clickRow row = (clickRow) Table.getChildAt(cnt);
                        if(row.isCheck())
                            check = check + 1;
                    }
                    if(check==Table.getChildCount()-1)
                        box.setChecked(true);
                    else
                        box.setChecked(false);
                }
            };

            row.setOnClickListener(Click_row);

            Table.addView(row);
        }
    }

    public static int getRow(TableLayout Table){

        int rownum=0;

        for(int cnt=1;cnt<Table.getChildCount();cnt++){
            clickRow row = (clickRow) Table.getChildAt(cnt);
            if(row.isCheck()){
                rownum=cnt;
            }
        }
        return rownum;
    }

    public TableLayout ClickAll(TableLayout Table, CheckBox box){

        if(box.isChecked()) {
            for (int cnt = 1; cnt < Table.getChildCount(); cnt++) {
                clickRow row = (clickRow) Table.getChildAt(cnt);
                for (int cnt2 = 0; cnt2 < row.getChildCount(); cnt2++) {
                    row.getChildAt(cnt2).setBackgroundResource(R.color.Select_color);
                }
                row.setCheck(true);
            }
        }else{
            for (int cnt = 1; cnt < Table.getChildCount(); cnt++) {
                clickRow row = (clickRow) Table.getChildAt(cnt);
                for (int cnt2 = 0; cnt2 < row.getChildCount(); cnt2++) {
                    row.getChildAt(cnt2).setBackgroundResource(R.color.table_white);
                }
                row.setCheck(false);
            }
        }
        return Table;
    }

    class Cell_Attr extends AppCompatTextView {

        public Cell_Attr(Context context) {
            super(context);
        }

        public Cell_Attr(Context mContext, String Text, boolean isColumn){

            super(mContext);
            this.setBackgroundResource(R.color.table_white);
            this.setGravity(Gravity.CENTER);
            this.setHeight(80);
            this.setTextSize(16);

            clickRow.LayoutParams c_params = new clickRow.LayoutParams(
                    clickRow.LayoutParams.WRAP_CONTENT,
                    clickRow.LayoutParams.WRAP_CONTENT
            );
            if(isColumn) {
                c_params.setMargins(1, 1, 1, 3);
            }else{
                c_params.setMargins(1, 1, 1, 1);
            }

            this.setLayoutParams(c_params);
            Text="  "+Text+"  ";
            this.setText(Text);
        }
    }

   public class clickRow extends TableRow{

        boolean check = false;

        public clickRow(Context context) {
            super(context);
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }
    }
}



