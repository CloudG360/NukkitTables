package dev.cg360.mc.nukkittables.basetypes;

import cn.nukkit.item.Item;
import dev.cg360.mc.nukkittables.Utility;
import dev.cg360.mc.nukkittables.context.TableRollContext;

import java.util.ArrayList;
import java.util.Arrays;

public class LootTable {

    protected String type;
    protected TablePool[] pools;

    public Item[] rollLootTable(TableRollContext context){
        ArrayList<Item> items = new ArrayList<>();
        for(TablePool pool: pools){
            if(Utility.compileConditions(pool.getConditions(), context)){
                items.addAll(Arrays.asList(pool.rollPool(context)));
            }
        }
        return items.toArray(new Item[0]);
    }

    public String getType() { return type; }
    public TablePool[] getPools() { return pools; }
}
