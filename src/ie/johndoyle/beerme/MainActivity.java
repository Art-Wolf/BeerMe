package ie.johndoyle.beerme;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.internal.view.menu.ActionMenuView.LayoutParams;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	static HashMap<String, Item> orders = new HashMap<String, Item>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			ImageButton beerButton = (ImageButton) rootView
					.findViewById(R.id.beerButton);
			ImageButton wineButton = (ImageButton) rootView
					.findViewById(R.id.wineButton);
			ImageButton cocktailButton = (ImageButton) rootView
					.findViewById(R.id.cocktailButton);
			ImageButton shotButton = (ImageButton) rootView
					.findViewById(R.id.shotButton);
			ImageButton orderButton = (ImageButton) rootView
					.findViewById(R.id.orderButton);

			beerButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new BeerFragment(),
							"BeerFragment");
					ft.commit();
				}
			});

			wineButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new WineFragment(),
							"WineFragment");
					ft.commit();
				}
			});

			cocktailButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new CocktailFragment(),
							"CocktailFragment");
					ft.commit();
				}
			});

			shotButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new ShotFragment(),
							"ShotFragment");
					ft.commit();
				}
			});

			orderButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new OrderFragment(),
							"OrderFragment");
					ft.commit();
				}
			});

			return rootView;
		}
	}

	public static class BeerFragment extends Fragment {
		public BeerFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.beer_main, container,
					false);

			ImageButton heinekenButton = (ImageButton) rootView
					.findViewById(R.id.heinekenButton);
			ImageButton tigerButton = (ImageButton) rootView
					.findViewById(R.id.tigerButton);
			ImageButton guinnessButton = (ImageButton) rootView
					.findViewById(R.id.guinnessButton);
			ImageButton magnersButton = (ImageButton) rootView
					.findViewById(R.id.magnersButton);

			ImageButton wineMenuButton = (ImageButton) rootView
					.findViewById(R.id.wineMenuButton);
			ImageButton shotMenuButton = (ImageButton) rootView
					.findViewById(R.id.shotMenuButton);
			ImageButton cocktailMenuButton = (ImageButton) rootView
					.findViewById(R.id.cocktailMenuButton);
			ImageButton orderMenuButton = (ImageButton) rootView
					.findViewById(R.id.orderMenuButton);

			heinekenButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Item heineken = (Item) orders.get("Heineken");
					if (heineken != null) {
						heineken.setQuantity(heineken.getQuantity() + 1);
						orders.put(heineken.getName(), heineken);

						Toast.makeText(getActivity(),
								"More Heineken Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newHeineken = new Item();
						newHeineken.setName("Heineken");
						newHeineken.setPrice(3.50);
						newHeineken.setQuantity(1);

						orders.put(newHeineken.getName(), newHeineken);
						Toast.makeText(getActivity(),
								"New Heineken Added to Order",
								Toast.LENGTH_SHORT).show();
					}

				}
			});

			tigerButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Item tiger = (Item) orders.get("Tiger");
					if (tiger != null) {
						tiger.setQuantity(tiger.getQuantity() + 1);
						orders.put(tiger.getName(), tiger);

						Toast.makeText(getActivity(),
								"More Tiger Added to Order", Toast.LENGTH_SHORT)
								.show();
					} else {
						Item newTiger = new Item();
						newTiger.setName("Tiger");
						newTiger.setPrice(2.75);
						newTiger.setQuantity(1);

						orders.put(newTiger.getName(), newTiger);
						Toast.makeText(getActivity(),
								"New Tiger Added to Order", Toast.LENGTH_SHORT)
								.show();
					}
				}
			});

			guinnessButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Item guinness = (Item) orders.get("Guinness");
					if (guinness != null) {
						guinness.setQuantity(guinness.getQuantity() + 1);
						orders.put(guinness.getName(), guinness);

						Toast.makeText(
								getActivity(),
								"More " + guinness.getName()
										+ " Added to Order", Toast.LENGTH_SHORT)
								.show();
					} else {
						Item newGuinness = new Item();
						newGuinness.setName("Guinness");
						newGuinness.setPrice(3.75);
						newGuinness.setQuantity(1);

						orders.put(newGuinness.getName(), newGuinness);
						Toast.makeText(getActivity(),
								newGuinness.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			magnersButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Item magners = (Item) orders.get("Magners");
					if (magners != null) {
						magners.setQuantity(magners.getQuantity() + 1);
						orders.put(magners.getName(), magners);

						Toast.makeText(
								getActivity(),
								"More " + magners.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newMagners = new Item();
						newMagners.setName("Magners");
						newMagners.setPrice(5.25);
						newMagners.setQuantity(1);

						orders.put(newMagners.getName(), newMagners);
						Toast.makeText(getActivity(),
								newMagners.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			wineMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new WineFragment(),
							"WineFragment");
					ft.commit();
				}
			});

			cocktailMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new CocktailFragment(),
							"CocktailFragment");
					ft.commit();
				}
			});

			shotMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new ShotFragment(),
							"ShotFragment");
					ft.commit();
				}
			});

			orderMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new OrderFragment(),
							"OrderFragment");
					ft.commit();
				}
			});

			return rootView;
		}
	}

	public static class WineFragment extends Fragment {
		public WineFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.wine_main, container,
					false);

			ImageButton ligenfelderButton = (ImageButton) rootView
					.findViewById(R.id.ligenfelderButton);
			ImageButton firstVineButton = (ImageButton) rootView
					.findViewById(R.id.firstVineButton);
			ImageButton franciscanEstateButton = (ImageButton) rootView
					.findViewById(R.id.franciscanEstateButton);
			ImageButton kenwoodButton = (ImageButton) rootView
					.findViewById(R.id.kenwoodButton);
			ImageButton wolfBassButton = (ImageButton) rootView
					.findViewById(R.id.wolfBassButton);

			ImageButton beerMenuButton = (ImageButton) rootView
					.findViewById(R.id.beerMenuButton);
			ImageButton shotMenuButton = (ImageButton) rootView
					.findViewById(R.id.shotMenuButton);
			ImageButton cocktailMenuButton = (ImageButton) rootView
					.findViewById(R.id.cocktailMenuButton);
			ImageButton orderMenuButton = (ImageButton) rootView
					.findViewById(R.id.orderMenuButton);

			ligenfelderButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Item ligenfelder = (Item) orders.get("Ligenfelder");
					if (ligenfelder != null) {
						ligenfelder.setQuantity(ligenfelder.getQuantity() + 1);
						orders.put(ligenfelder.getName(), ligenfelder);

						Toast.makeText(
								getActivity(),
								"More " + ligenfelder.getName()
										+ " Added to Order", Toast.LENGTH_SHORT)
								.show();
					} else {
						Item newLigenfelder = new Item();
						newLigenfelder.setName("Ligenfelder");
						newLigenfelder.setPrice(4.44);
						newLigenfelder.setQuantity(1);

						orders.put(newLigenfelder.getName(), newLigenfelder);
						Toast.makeText(getActivity(),
								newLigenfelder.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			firstVineButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "First Vine";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(3.45);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			franciscanEstateButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Franciscan Estate";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(5.10);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			kenwoodButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Kenwood";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(7.25);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			wolfBassButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Wolf Bass";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(5.15);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			beerMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new BeerFragment(),
							"BeerFragment");
					ft.commit();
				}
			});

			cocktailMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new CocktailFragment(),
							"CocktailFragment");
					ft.commit();
				}
			});

			shotMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new ShotFragment(),
							"ShotFragment");
					ft.commit();
				}
			});

			orderMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new OrderFragment(),
							"OrderFragment");
					ft.commit();
				}
			});

			return rootView;
		}
	}

	public static class ShotFragment extends Fragment {
		public ShotFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.shot_main, container,
					false);

			ImageButton blackRussianButton = (ImageButton) rootView
					.findViewById(R.id.blackRussianButton);
			ImageButton irishFlagButton = (ImageButton) rootView
					.findViewById(R.id.irishFlagButton);
			ImageButton orgasmButton = (ImageButton) rootView
					.findViewById(R.id.orgasmButton);
			ImageButton fourHorsemenButton = (ImageButton) rootView
					.findViewById(R.id.fourHorsemenButton);

			ImageButton wineMenuButton = (ImageButton) rootView
					.findViewById(R.id.wineMenuButton);
			ImageButton beerMenuButton = (ImageButton) rootView
					.findViewById(R.id.beerMenuButton);
			ImageButton cocktailMenuButton = (ImageButton) rootView
					.findViewById(R.id.cocktailMenuButton);
			ImageButton orderMenuButton = (ImageButton) rootView
					.findViewById(R.id.orderMenuButton);

			blackRussianButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Black Russian";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(5.25);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			irishFlagButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Irish Flag";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(5.25);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			orgasmButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Orgasm";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(5.25);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			fourHorsemenButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Four Horsemen";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(5.25);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			wineMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new WineFragment(),
							"WineFragment");
					ft.commit();
				}
			});

			cocktailMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new CocktailFragment(),
							"CocktailFragment");
					ft.commit();
				}
			});

			beerMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new BeerFragment(),
							"BeerFragment");
					ft.commit();
				}
			});

			orderMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new OrderFragment(),
							"OrderFragment");
					ft.commit();
				}
			});

			return rootView;
		}
	}

	public static class CocktailFragment extends Fragment {
		public CocktailFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.cocktail_main, container,
					false);

			ImageButton oldFashionedButton = (ImageButton) rootView
					.findViewById(R.id.oldFashionedButton);
			ImageButton martiniButton = (ImageButton) rootView
					.findViewById(R.id.martiniButton);
			ImageButton daiquiriButton = (ImageButton) rootView
					.findViewById(R.id.daiquiriButton);
			ImageButton maiTaiButton = (ImageButton) rootView
					.findViewById(R.id.maiTaiButton);

			ImageButton wineMenuButton = (ImageButton) rootView
					.findViewById(R.id.wineMenuButton);
			ImageButton shotMenuButton = (ImageButton) rootView
					.findViewById(R.id.shotMenuButton);
			ImageButton beerMenuButton = (ImageButton) rootView
					.findViewById(R.id.beerMenuButton);
			ImageButton orderMenuButton = (ImageButton) rootView
					.findViewById(R.id.orderMenuButton);

			oldFashionedButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Old Fashioned";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(10.0);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			martiniButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Martini";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(10.0);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			daiquiriButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Daiquiri";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(10.0);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			maiTaiButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String itemName = "Mai Tai";
					Item item = (Item) orders.get(itemName);
					if (item != null) {
						item.setQuantity(item.getQuantity() + 1);
						orders.put(item.getName(), item);

						Toast.makeText(getActivity(),
								"More " + item.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					} else {
						Item newItem = new Item();
						newItem.setName(itemName);
						newItem.setPrice(10.0);
						newItem.setQuantity(1);

						orders.put(newItem.getName(), newItem);
						Toast.makeText(getActivity(),
								newItem.getName() + " Added to Order",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			wineMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new WineFragment(),
							"WineFragment");
					ft.commit();
				}
			});

			beerMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new BeerFragment(),
							"BeerFragment");
					ft.commit();
				}
			});

			shotMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new ShotFragment(),
							"ShotFragment");
					ft.commit();
				}
			});

			orderMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new OrderFragment(),
							"OrderFragment");
					ft.commit();
				}
			});

			return rootView;
		}
	}

	public static class OrderFragment extends Fragment {
		public OrderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.order_main, container,
					false);

			TableLayout table = (TableLayout) rootView
					.findViewById(R.id.orderTable);

			Iterator<Entry<String, Item>> itemIterator = orders.entrySet()
					.iterator();

			TableRow tbrow = new TableRow(getActivity().getApplicationContext());

			TextView itemName = new TextView(getActivity()
					.getApplicationContext());
			SpannableString spanString = new SpannableString("Item");
			spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
			spanString.setSpan(new StyleSpan(Typeface.BOLD), 0,
					spanString.length(), 0);
			itemName.setText(spanString);
			tbrow.addView(itemName);
			TextView itemQty = new TextView(getActivity()
					.getApplicationContext());
			spanString = new SpannableString("Qty");
			spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
			spanString.setSpan(new StyleSpan(Typeface.BOLD), 0,
					spanString.length(), 0);
			itemQty.setText(spanString);
			tbrow.addView(itemQty);
			TextView itemTotal = new TextView(getActivity()
					.getApplicationContext());
			spanString = new SpannableString("Total");
			spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
			spanString.setSpan(new StyleSpan(Typeface.BOLD), 0,
					spanString.length(), 0);
			itemTotal.setText(spanString);
			tbrow.addView(itemTotal);
			table.addView(tbrow, new TableLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			while (itemIterator.hasNext()) {
				Entry<String, Item> entry = (Entry<String, Item>) itemIterator
						.next();
				Item item = (Item) entry.getValue();

				tbrow = new TableRow(getActivity().getApplicationContext());

				itemName = new TextView(getActivity().getApplicationContext());
				itemName.setText(item.getName());

				tbrow.addView(itemName);

				TextView itemQuantity = new TextView(getActivity()
						.getApplicationContext());
				itemQuantity.setText(Integer.toString(item.getQuantity()));

				tbrow.addView(itemQuantity);

				itemTotal = new TextView(getActivity().getApplicationContext());
				itemTotal
						.setText("$"
								+ Double.toString(item.getPrice()
										* item.getQuantity()));

				tbrow.addView(itemTotal);

				table.addView(tbrow, new TableLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			}

			ImageButton cocktailMenuButton = (ImageButton) rootView
					.findViewById(R.id.cocktailMenuButton);
			ImageButton wineMenuButton = (ImageButton) rootView
					.findViewById(R.id.wineMenuButton);
			ImageButton shotMenuButton = (ImageButton) rootView
					.findViewById(R.id.shotMenuButton);
			ImageButton beerMenuButton = (ImageButton) rootView
					.findViewById(R.id.beerMenuButton);
			Button cancelButton = (Button) rootView
					.findViewById(R.id.cancelButton);
			
			cocktailMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new CocktailFragment(),
							"CocktailFragment");
					ft.commit();
				}
			});

			wineMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new WineFragment(),
							"WineFragment");
					ft.commit();
				}
			});

			beerMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new BeerFragment(),
							"BeerFragment");
					ft.commit();
				}
			});

			shotMenuButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.addToBackStack(null);
					ft.replace(R.id.container, new ShotFragment(),
							"ShotFragment");
					ft.commit();
				}
			});

			cancelButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					orders.clear();
					final FragmentTransaction ft = getFragmentManager()
							.beginTransaction();
					ft.replace(R.id.container, new OrderFragment(),
							"OrderFragment");
					ft.commit();
				}
			});
			
			return rootView;
		}
	}
}
