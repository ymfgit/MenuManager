package wg.media.screen.model.datasea.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFood<M extends BaseFood<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setTypeFirstId(java.lang.Integer typeFirstId) {
		set("typeFirstId", typeFirstId);
	}
	
	public java.lang.Integer getTypeFirstId() {
		return getInt("typeFirstId");
	}

	public void setTypeSecondId(java.lang.Integer typeSecondId) {
		set("typeSecondId", typeSecondId);
	}
	
	public java.lang.Integer getTypeSecondId() {
		return getInt("typeSecondId");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public void setAlias(java.lang.String alias) {
		set("alias", alias);
	}
	
	public java.lang.String getAlias() {
		return getStr("alias");
	}

	public void setImgUrl(java.lang.String imgUrl) {
		set("imgUrl", imgUrl);
	}
	
	public java.lang.String getImgUrl() {
		return getStr("imgUrl");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}
	
	public java.lang.String getDescription() {
		return getStr("description");
	}

	public void setTaboos(java.lang.String taboos) {
		set("taboos", taboos);
	}
	
	public java.lang.String getTaboos() {
		return getStr("taboos");
	}

	public void setSuitable(java.lang.String suitable) {
		set("suitable", suitable);
	}
	
	public java.lang.String getSuitable() {
		return getStr("suitable");
	}

	public void setEffect(java.lang.String effect) {
		set("effect", effect);
	}
	
	public java.lang.String getEffect() {
		return getStr("effect");
	}

	public void setNutritionalValue(java.lang.String nutritionalValue) {
		set("nutritionalValue", nutritionalValue);
	}
	
	public java.lang.String getNutritionalValue() {
		return getStr("nutritionalValue");
	}

	public void setHowToSelect(java.lang.String howToSelect) {
		set("howToSelect", howToSelect);
	}
	
	public java.lang.String getHowToSelect() {
		return getStr("howToSelect");
	}

	public void setHowToStore(java.lang.String howToStore) {
		set("howToStore", howToStore);
	}
	
	public java.lang.String getHowToStore() {
		return getStr("howToStore");
	}

	public void setHowToEating(java.lang.String howToEating) {
		set("howToEating", howToEating);
	}
	
	public java.lang.String getHowToEating() {
		return getStr("howToEating");
	}

	public void setRestraint(java.lang.String restraint) {
		set("restraint", restraint);
	}
	
	public java.lang.String getRestraint() {
		return getStr("restraint");
	}

	public void setUseful(java.lang.String useful) {
		set("useful", useful);
	}
	
	public java.lang.String getUseful() {
		return getStr("useful");
	}

	public void setSort(java.lang.Integer sort) {
		set("sort", sort);
	}
	
	public java.lang.Integer getSort() {
		return getInt("sort");
	}

	public void setLinkUrl(java.lang.String linkUrl) {
		set("linkUrl", linkUrl);
	}
	
	public java.lang.String getLinkUrl() {
		return getStr("linkUrl");
	}

}
