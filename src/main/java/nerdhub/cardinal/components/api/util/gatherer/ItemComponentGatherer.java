package nerdhub.cardinal.components.api.util.gatherer;

import nerdhub.cardinal.components.api.component.container.ComponentContainer;
import nerdhub.cardinal.components.api.event.ComponentGatherer;
import net.minecraft.item.ItemStack;

/**
 * A {@link ComponentGatherer} specialized for item stacks. 
 *
 * <p> If an {@code Item} implements this interface, its {@link ItemComponentGatherer#initComponents}
 * method will be automatically called for every item stack created that holds this item.
 */
public interface ItemComponentGatherer extends ComponentGatherer<ItemStack> {
    @Override
    void initComponents(ItemStack stack, ComponentContainer cc);
}