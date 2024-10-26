package me.CHANGEME.slimefunaddon;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
//import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;

public class hseertech extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // 从 config.yml 中读取插件配置
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // 你可以在这里添加自动更新功能
        }

        /*
         * 1. 创建分类
         * 分类的显示物品将使用以下物品
         */

        CustomItemStack New_CustomItemStack = new CustomItemStack(Material.DIAMOND, "&e真石科技-物品");
        CustomItemStack Cailiao_CustomItemStack = new CustomItemStack(Material.FURNACE, "&e真石科技-材料");
        CustomItemStack Jiqi_CustomItemStack = new CustomItemStack(Material.CAKE, "&e真石科技-机器");





        // 给你的分类提供一个独一无二的ID
        NamespacedKey itemGroupId = new NamespacedKey(this, "hseertech");
        ItemGroup wupin = new ItemGroup(itemGroupId, New_CustomItemStack);
        ItemGroup cailiao = new ItemGroup(itemGroupId, Cailiao_CustomItemStack);
        ItemGroup jiqi = new ItemGroup(itemGroupId, Jiqi_CustomItemStack);


        /*
         * 2. 创建一个 SlimefunItemStack
         * 这个类是 ItemStack 的扩展，拥有多个构造函数
         * 重要：每个物品都得有一个独一无二的ID
         */
        SlimefunItemStack HSEER_SHI = new SlimefunItemStack("HSEER_SHI", Material.STONE, "&a石", "", "&7和石一样?");
        SlimefunItemStack HSEER_BETTER_SHI = new SlimefunItemStack("HSEER_BETTER_SHI", Material.STONE_BRICKS, "&a高级石", "", "&7更好的石");
        SlimefunItemStack HSEER_SMALL_SHI = new SlimefunItemStack("HSEER_SMALL_SHI", Material.STONE_BUTTON, "小石", "", "什么玩意?");
        SlimefunItemStack HSEER_HUOGUO = new SlimefunItemStack("HSEER_HUOGUO", Material.CAULDRON, "&粹炼炉", "", "&c炼石炉????");
        SlimefunItemStack HSEER_BEST_SHI = new SlimefunItemStack("HSEER_BEST_SHI", Material.WARPED_BUTTON, "&好石", "", "&b最好的石");
        SlimefunItemStack HSEER_SHI_DING = new SlimefunItemStack("HSEER_SHI_DING", Material.IRON_INGOT, "&B石锭", "&f真石!!!!!!!!!!");

        /*
         * 3. 创建配方
         * 这个配方是一个拥有9个ItemStack的数组。
         * 它代表了一个3x3的有序合成配方。
         * 该配方所需的机器将在后面通过RecipeType指定。
         */
        ItemStack[] smallshiStack = { new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE) };
        ItemStack[] bettershStack = { 
            HSEER_SHI,    HSEER_SHI,    HSEER_SHI,
            HSEER_SHI,     HSEER_SHI,    HSEER_SHI,
            HSEER_SHI,     HSEER_SHI,    HSEER_SHI,
        };
        ItemStack[] Bestshstack = {
            HSEER_BETTER_SHI,  HSEER_BETTER_SHI, HSEER_BETTER_SHI,
            HSEER_BETTER_SHI,  HSEER_BETTER_SHI, HSEER_BETTER_SHI,
            HSEER_BETTER_SHI,  HSEER_BETTER_SHI, HSEER_BETTER_SHI,
        };
        ItemStack[] HuoguoStack = {
            HSEER_BEST_SHI, HSEER_BEST_SHI, HSEER_BEST_SHI,
            new ItemStack(Material.FLINT), new ItemStack(Material.CAULDRON), new ItemStack(Material.FLINT),
            HSEER_BEST_SHI, HSEER_BEST_SHI, HSEER_BEST_SHI,
        };
        ItemStack[] ShidingStack = {
            HSEER_BEST_SHI, HSEER_BETTER_SHI
        };
        ItemStack[] SHhidingshuchuStack = {
            HSEER_SHI_DING
        };
        

        /*
         * 4. 注册物品
         * 现在，你只需要注册物品
         * RecipeType.ENHANCED_CRAFTING_TABLE 代表
         * 该物品将在增强型工作台中合成。
         * 来自粘液科技本体的配方类型将会自动将配方添加到对应的机器中。
         */
        //SlimefunItem shi =  new SlimefunItem(cailiao, HSEER_SHI, RecipeType.ENHANCED_CRAFTING_TABLE, Bestshstack);
        SlimefunItem smallshi = new SlimefunItem(cailiao, HSEER_SMALL_SHI, RecipeType.ENHANCED_CRAFTING_TABLE, smallshiStack);
        SlimefunItem bettershi = new SlimefunItem(cailiao, HSEER_BETTER_SHI, RecipeType.ENHANCED_CRAFTING_TABLE, bettershStack);
        SlimefunItem bestshi = new SlimefunItem(cailiao, HSEER_BEST_SHI, RecipeType.ENHANCED_CRAFTING_TABLE, Bestshstack);
        simplemachine huoguo = new simplemachine(jiqi, HSEER_HUOGUO, RecipeType.ENHANCED_CRAFTING_TABLE, HuoguoStack);
        //shi.register(this);
        smallshi.register(this);
        bettershi.register(this);
        bestshi.register(this);
        huoguo.register(this);

        //机器
        jiqi cuilian = new jiqi(jiqi, HSEER_HUOGUO, ShidingStack, HSEER_SHI_DING);
    }

    //机器配方
    //@ParametersAreNonnullByDefault

   // }
    //自己写的一堆类
    public class simplemachine extends SlimefunItem {
        @ParametersAreNonnullByDefault
        public simplemachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
            super(itemGroup, item, recipeType, recipe);
        }

      //  @Override
       // public void preRegister() {
          //  BlockUseHandler huoguohandler = this::onBlockRightClick;
           // addItemHandler(huoguohandler);
            
       // }

       // private void onBlockRightClick(PlayerRightClickEvent event) {
    // This method will now be called whenever this Block is right-clicked.
         //   menu.open(player)
        //}
        
        
    }
   // public abstract void AContainer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    public abstract class jiqi extends AContainer {

        protected jiqi(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
                ItemStack[] recipe, ItemStack recipeOutput) {
            super(itemGroup, item, recipeType, recipe, recipeOutput);
            //TODO Auto-generated constructor stub
        }

    }
    

    @Override
    public void onDisable() {
        // 禁用插件的逻辑...
    }

    @Override
    public String getBugTrackerURL() {
        // 你可以在这里返回你的问题追踪器的网址，而不是 null
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * 你需要返回对你插件的引用。
         * 如果这是你插件的主类，只需要返回 "this" 即可。
         */
        return this;
    }

}
