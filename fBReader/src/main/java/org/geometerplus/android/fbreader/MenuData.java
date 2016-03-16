/*
 * Copyright (C) 2009-2015 FBReader.ORG Limited <contact@fbreader.org>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.android.fbreader;

import org.geometerplus.android.fbreader.api.MenuNode;
import org.geometerplus.fbreader.fbreader.ActionCode;
import org.geometerplus.zlibrary.core.library.ZLibrary;
import org.geometerplus.zlibrary.ui.android.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MenuData {
	private static List<MenuNode> ourNodes;

	private static void addToplevelNode(MenuNode node) {
		ourNodes.add(node);
	}

	public static synchronized List<MenuNode> topLevelNodes() {
		if (ourNodes == null) {
			ourNodes = new ArrayList<MenuNode>();
			addToplevelNode(new MenuNode.Item(ActionCode.SHOW_LIBRARY, R.drawable.setting_local_book));
			addToplevelNode(new MenuNode.Item(ActionCode.SHOW_NETWORK_LIBRARY, R.drawable.setting_online_book));
			addToplevelNode(new MenuNode.Item(ActionCode.SHOW_TOC, R.drawable.setting_dir));
			addToplevelNode(new MenuNode.Item(ActionCode.SHOW_BOOKMARKS, R.drawable.setting_bookmark2));
			addToplevelNode(new MenuNode.Item(ActionCode.SWITCH_TO_NIGHT_PROFILE, R.drawable.setting_dark));
			addToplevelNode(new MenuNode.Item(ActionCode.SWITCH_TO_DAY_PROFILE, R.drawable.setting_day));
			addToplevelNode(new MenuNode.Item(ActionCode.SEARCH, R.drawable.setting_book_search));
			addToplevelNode(new MenuNode.Item(ActionCode.SHARE_BOOK,R.drawable.setting_share));
			addToplevelNode(new MenuNode.Item(ActionCode.SHOW_PREFERENCES,R.drawable.setting_set));
			addToplevelNode(new MenuNode.Item(ActionCode.SHOW_BOOK_INFO,R.drawable.setting_book_info));
			final MenuNode.Submenu orientations = new MenuNode.Submenu("screenOrientation");
			orientations.Children.add(new MenuNode.Item(ActionCode.SET_SCREEN_ORIENTATION_SYSTEM));
			orientations.Children.add(new MenuNode.Item(ActionCode.SET_SCREEN_ORIENTATION_SENSOR));
			orientations.Children.add(new MenuNode.Item(ActionCode.SET_SCREEN_ORIENTATION_PORTRAIT));
			orientations.Children.add(new MenuNode.Item(ActionCode.SET_SCREEN_ORIENTATION_LANDSCAPE));
			if (ZLibrary.Instance().supportsAllOrientations()) {
				orientations.Children.add(new MenuNode.Item(ActionCode.SET_SCREEN_ORIENTATION_REVERSE_PORTRAIT));
				orientations.Children.add(new MenuNode.Item(ActionCode.SET_SCREEN_ORIENTATION_REVERSE_LANDSCAPE));
			}
			addToplevelNode(orientations);
			addToplevelNode(new MenuNode.Item(ActionCode.INCREASE_FONT,R.drawable.setting_font_big));
			addToplevelNode(new MenuNode.Item(ActionCode.DECREASE_FONT,R.drawable.setting_font_small));
			addToplevelNode(new MenuNode.Item(ActionCode.SHOW_NAVIGATION,R.drawable.setting_fast_progress2));
			addToplevelNode(new MenuNode.Item(ActionCode.INSTALL_PLUGINS,R.drawable.setting_plug2));
			addToplevelNode(new MenuNode.Item(ActionCode.OPEN_WEB_HELP,R.drawable.setting_help));
			addToplevelNode(new MenuNode.Item(ActionCode.OPEN_START_SCREEN,R.drawable.setting_start_screen2));
			ourNodes = Collections.unmodifiableList(ourNodes);
		}
		return ourNodes;
	}
}
