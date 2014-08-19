package com.srinivas.bodagala.bookmyshow;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class BookMyShowObject implements Parcelable {

	private BookMyShow BookMyShow;

	public BookMyShowObject() {
		// TODO Auto-generated constructor stub
		BookMyShow = new BookMyShow();
	}

	public BookMyShow getBookMyShow() {
		return BookMyShow;
	}

	public void setBookMyShow(BookMyShow bookMyShow) {
		BookMyShow = bookMyShow;
	}

	public static class BookMyShow implements Parcelable {

		public ArrayList<ArrayVenue> arrVenue;
		public ArrayList<ArrayShowTimes> arrShowTimes;

		public BookMyShow() {
			// TODO Auto-generated constructor stub
			arrVenue = new ArrayList<ArrayVenue>();
			arrShowTimes = new ArrayList<ArrayShowTimes>();
		}

		public ArrayList<ArrayVenue> getArrVenue() {
			return arrVenue;
		}

		public void setArrVenue(ArrayList<ArrayVenue> arrVenue) {
			this.arrVenue = arrVenue;
		}

		public ArrayList<ArrayShowTimes> getArrShowTimes() {
			return arrShowTimes;
		}

		public void setArrShowTimes(ArrayList<ArrayShowTimes> arrShowTimes) {
			this.arrShowTimes = arrShowTimes;
		}

		public static class ArrayVenue implements Parcelable {

			public String EventCode, EventName, ImageCode, EventType, Ratings,
					Actors, Director, Genre, Language, Length, TrailerURL, Seq,
					EventSynopsis, EventReleaseDate, EventIsGlobal, BannerURL,
					FShareURL;

			public ArrayVenue() {
				// TODO Auto-generated constructor stub
			}

			public String getEventCode() {
				return EventCode;
			}

			public void setEventCode(String eventCode) {
				EventCode = eventCode;
			}

			public String getEventName() {
				return EventName;
			}

			public void setEventName(String eventName) {
				EventName = eventName;
			}

			public String getImageCode() {
				return ImageCode;
			}

			public void setImageCode(String imageCode) {
				ImageCode = imageCode;
			}

			public String getEventType() {
				return EventType;
			}

			public void setEventType(String eventType) {
				EventType = eventType;
			}

			public String getRatings() {
				return Ratings;
			}

			public void setRatings(String ratings) {
				Ratings = ratings;
			}

			public String getActors() {
				return Actors;
			}

			public void setActors(String actors) {
				Actors = actors;
			}

			public String getDirector() {
				return Director;
			}

			public void setDirector(String director) {
				Director = director;
			}

			public String getGenre() {
				return Genre;
			}

			public void setGenre(String genre) {
				Genre = genre;
			}

			public String getLanguage() {
				return Language;
			}

			public void setLanguage(String language) {
				Language = language;
			}

			public String getLength() {
				return Length;
			}

			public void setLength(String length) {
				Length = length;
			}

			public String getTrailerURL() {
				return TrailerURL;
			}

			public void setTrailerURL(String trailerURL) {
				TrailerURL = trailerURL;
			}

			public String getSeq() {
				return Seq;
			}

			public void setSeq(String seq) {
				Seq = seq;
			}

			public String getEventSynopsis() {
				return EventSynopsis;
			}

			public void setEventSynopsis(String eventSynopsis) {
				EventSynopsis = eventSynopsis;
			}

			public String getEventReleaseDate() {
				return EventReleaseDate;
			}

			public void setEventReleaseDate(String eventReleaseDate) {
				EventReleaseDate = eventReleaseDate;
			}

			public String getEventIsGlobal() {
				return EventIsGlobal;
			}

			public void setEventIsGlobal(String eventIsGlobal) {
				EventIsGlobal = eventIsGlobal;
			}

			public String getBannerURL() {
				return BannerURL;
			}

			public void setBannerURL(String bannerURL) {
				BannerURL = bannerURL;
			}

			public String getFShareURL() {
				return FShareURL;
			}

			public void setFShareURL(String fShareURL) {
				FShareURL = fShareURL;
			}

			@Override
			public int describeContents() {
				// TODO Auto-generated method stub
				return 0;
			}

			private ArrayVenue(Parcel in) {
				this.EventCode = in.readString();
				this.EventName = in.readString();
				this.ImageCode = in.readString();
				this.EventType = in.readString();
				this.Ratings = in.readString();
				this.Actors = in.readString();
				this.Director = in.readString();
				this.Genre = in.readString();
				this.Language = in.readString();
				this.Length = in.readString();
				this.TrailerURL = in.readString();
				this.Seq = in.readString();
				this.EventSynopsis = in.readString();
				this.EventReleaseDate = in.readString();
				this.EventIsGlobal = in.readString();
				this.BannerURL = in.readString();
				this.FShareURL = in.readString();
			}

			@Override
			public void writeToParcel(Parcel dest, int flags) {
				// TODO Auto-generated method stub

				dest.writeString(EventCode);
				dest.writeString(EventName);
				dest.writeString(ImageCode);
				dest.writeString(EventType);
				dest.writeString(Ratings);
				dest.writeString(Actors);
				dest.writeString(Director);
				dest.writeString(Genre);
				dest.writeString(Language);
				dest.writeString(Length);
				dest.writeString(TrailerURL);
				dest.writeString(Seq);
				dest.writeString(EventSynopsis);
				dest.writeString(EventReleaseDate);
				dest.writeString(EventIsGlobal);
				dest.writeString(BannerURL);
				dest.writeString(FShareURL);
			}

			public static final Parcelable.Creator<ArrayVenue> CREATOR = new Parcelable.Creator<ArrayVenue>() {

				@Override
				public ArrayVenue createFromParcel(Parcel source) {
					// TODO Auto-generated method stub
					return new ArrayVenue(source);
				}

				@Override
				public ArrayVenue[] newArray(int size) {
					// TODO Auto-generated method stub
					return new ArrayVenue[size];
				}
			};

		}

		public static class ArrayShowTimes implements Parcelable {

			public String ShowDateCode, ShowDateDisplay;
			public ArrayList<ArrayVenues> arrVenues;

			public ArrayShowTimes() {
				// TODO Auto-generated constructor stub
				arrVenues = new ArrayList<ArrayVenues>();
			}

			public String getShowDateCode() {
				return ShowDateCode;
			}

			public void setShowDateCode(String showDateCode) {
				ShowDateCode = showDateCode;
			}

			public String getShowDateDisplay() {
				return ShowDateDisplay;
			}

			public void setShowDateDisplay(String showDateDisplay) {
				ShowDateDisplay = showDateDisplay;
			}

			public ArrayList<ArrayVenues> getArrVenues() {
				return arrVenues;
			}

			public void setArrVenues(ArrayList<ArrayVenues> arrVenues) {
				this.arrVenues = arrVenues;
			}

			public static class ArrayVenues implements Parcelable {

				public String VenueCode, VenueName, VenueAddress, VenueSeq,
						VenueLatitude, VenueLongitude, VenueDistance, Legends,
						Message, MessageType, MessageTitle, ShowAvailInfo,
						SubRegion_strCode, Region_strCode;

				public ArrayList<ArrayShowTimes2> arrShowTimes;

				public ArrayVenues() {
					// TODO Auto-generated constructor stub
					arrShowTimes = new ArrayList<ArrayShowTimes2>();
				}

				public String getVenueCode() {
					return VenueCode;
				}

				public void setVenueCode(String venueCode) {
					VenueCode = venueCode;
				}

				public String getVenueName() {
					return VenueName;
				}

				public void setVenueName(String venueName) {
					VenueName = venueName;
				}

				public String getVenueAddress() {
					return VenueAddress;
				}

				public void setVenueAddress(String venueAddress) {
					VenueAddress = venueAddress;
				}

				public String getVenueSeq() {
					return VenueSeq;
				}

				public void setVenueSeq(String venueSeq) {
					VenueSeq = venueSeq;
				}

				public String getVenueLatitude() {
					return VenueLatitude;
				}

				public void setVenueLatitude(String venueLatitude) {
					VenueLatitude = venueLatitude;
				}

				public String getVenueLongitude() {
					return VenueLongitude;
				}

				public void setVenueLongitude(String venueLongitude) {
					VenueLongitude = venueLongitude;
				}

				public String getVenueDistance() {
					return VenueDistance;
				}

				public void setVenueDistance(String venueDistance) {
					VenueDistance = venueDistance;
				}

				public String getLegends() {
					return Legends;
				}

				public void setLegends(String legends) {
					Legends = legends;
				}

				public String getMessage() {
					return Message;
				}

				public void setMessage(String message) {
					Message = message;
				}

				public String getMessageTitle() {
					return MessageTitle;
				}

				public void setMessageTitle(String messageTitle) {
					MessageTitle = messageTitle;
				}

				public String getShowAvailInfo() {
					return ShowAvailInfo;
				}

				public void setShowAvailInfo(String showAvailInfo) {
					ShowAvailInfo = showAvailInfo;
				}

				public String getSubRegion_strCode() {
					return SubRegion_strCode;
				}

				public void setSubRegion_strCode(String subRegion_strCode) {
					SubRegion_strCode = subRegion_strCode;
				}

				public String getRegion_strCode() {
					return Region_strCode;
				}

				public void setRegion_strCode(String region_strCode) {
					Region_strCode = region_strCode;
				}

				public ArrayList<ArrayShowTimes2> getArrShowTimes() {
					return arrShowTimes;
				}

				public void setArrShowTimes(
						ArrayList<ArrayShowTimes2> arrShowTimes) {
					this.arrShowTimes = arrShowTimes;
				}

				public static class ArrayShowTimes2 implements Parcelable {

					public String SessionId, TotalSeats, SeatsAvail,
							ShowTimeNumeric, ShowTimeDisplay, VenueSeq;

					public ArrayShowTimes2() {
						// TODO Auto-generated constructor stub
					}

					public String getSessionId() {
						return SessionId;
					}

					public void setSessionId(String sessionId) {
						SessionId = sessionId;
					}

					public String getTotalSeats() {
						return TotalSeats;
					}

					public void setTotalSeats(String totalSeats) {
						TotalSeats = totalSeats;
					}

					public String getSeatsAvail() {
						return SeatsAvail;
					}

					public void setSeatsAvail(String seatsAvail) {
						SeatsAvail = seatsAvail;
					}

					public String getShowTimeNumeric() {
						return ShowTimeNumeric;
					}

					public void setShowTimeNumeric(String showTimeNumeric) {
						ShowTimeNumeric = showTimeNumeric;
					}

					public String getShowTimeDisplay() {
						return ShowTimeDisplay;
					}

					public void setShowTimeDisplay(String showTimeDisplay) {
						ShowTimeDisplay = showTimeDisplay;
					}

					public String getVenueSeq() {
						return VenueSeq;
					}

					public void setVenueSeq(String venueSeq) {
						VenueSeq = venueSeq;
					}

					@Override
					public int describeContents() {
						// TODO Auto-generated method stub
						return 0;
					}

					@Override
					public void writeToParcel(Parcel dest, int flags) {
						// TODO Auto-generated method stub

						dest.writeString(SessionId);
						dest.writeString(TotalSeats);
						dest.writeString(SeatsAvail);
						dest.writeString(ShowTimeNumeric);
						dest.writeString(ShowTimeDisplay);
						dest.writeString(VenueSeq);
					}

					private ArrayShowTimes2(Parcel in) {

						this.SessionId = in.readString();
						this.TotalSeats = in.readString();
						this.SeatsAvail = in.readString();
						this.ShowTimeNumeric = in.readString();
						this.ShowTimeDisplay = in.readString();
						this.VenueSeq = in.readString();

					}

					public static final Parcelable.Creator<ArrayShowTimes2> CREATOR = new Parcelable.Creator<ArrayShowTimes2>() {

						@Override
						public ArrayShowTimes2 createFromParcel(Parcel source) {
							// TODO Auto-generated method stub
							return new ArrayShowTimes2(source);
						}

						@Override
						public ArrayShowTimes2[] newArray(int size) {
							// TODO Auto-generated method stub
							return new ArrayShowTimes2[size];
						}
					};

				}

				@Override
				public int describeContents() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public void writeToParcel(Parcel dest, int flags) {
					// TODO Auto-generated method stub
					dest.writeString(VenueCode);
					dest.writeString(VenueName);
					dest.writeString(VenueAddress);
					dest.writeString(VenueSeq);
					dest.writeString(VenueLatitude);
					dest.writeString(VenueLongitude);
					dest.writeString(VenueDistance);
					dest.writeString(Legends);
					dest.writeString(Message);
					dest.writeString(MessageType);
					dest.writeString(MessageTitle);
					dest.writeString(ShowAvailInfo);
					dest.writeString(SubRegion_strCode);
					dest.writeString(Region_strCode);
					dest.writeTypedList(arrShowTimes);
				}

				private ArrayVenues(Parcel in) {
					this();
					VenueCode = in.readString();
					VenueName = in.readString();
					VenueAddress = in.readString();
					VenueSeq = in.readString();
					VenueLatitude = in.readString();
					VenueLongitude = in.readString();
					VenueDistance = in.readString();
					Legends = in.readString();
					Message = in.readString();
					MessageType = in.readString();
					MessageTitle = in.readString();
					ShowAvailInfo = in.readString();
					SubRegion_strCode = in.readString();
					Region_strCode = in.readString();
					in.readTypedList(arrShowTimes, ArrayShowTimes2.CREATOR);

				}

				public static final Parcelable.Creator<ArrayVenues> CREATOR = new Parcelable.Creator<ArrayVenues>() {

					@Override
					public ArrayVenues createFromParcel(Parcel source) {
						// TODO Auto-generated method stub
						return new ArrayVenues(source);
					}

					@Override
					public ArrayVenues[] newArray(int size) {
						// TODO Auto-generated method stub
						return new ArrayVenues[size];
					}
				};
			}

			@Override
			public int describeContents() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void writeToParcel(Parcel dest, int flags) {
				// TODO Auto-generated method stub
				dest.writeString(ShowDateCode);
				dest.writeString(ShowDateDisplay);
				dest.writeTypedList(arrVenues);
			}

			private ArrayShowTimes(Parcel in) {
				this();
				ShowDateCode = in.readString();
				ShowDateDisplay = in.readString();
				in.readTypedList(arrVenues, ArrayVenues.CREATOR);
			}

			public static final Parcelable.Creator<ArrayShowTimes> CREATOR = new Parcelable.Creator<ArrayShowTimes>() {

				@Override
				public ArrayShowTimes createFromParcel(Parcel source) {
					// TODO Auto-generated method stub
					return new ArrayShowTimes(source);
				}

				@Override
				public ArrayShowTimes[] newArray(int size) {
					// TODO Auto-generated method stub
					return new ArrayShowTimes[size];
				}
			};

		}

		@Override
		public int describeContents() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			// TODO Auto-generated method stub
			dest.writeTypedList(arrVenue);
			dest.writeTypedList(arrShowTimes);
		}

		private BookMyShow(Parcel in) {
			this();
			in.readTypedList(arrVenue, ArrayVenue.CREATOR);
			in.readTypedList(arrShowTimes, ArrayShowTimes.CREATOR);
		}

		public static final Parcelable.Creator<BookMyShow> CREATOR = new Parcelable.Creator<BookMyShow>() {

			@Override
			public BookMyShow createFromParcel(Parcel source) {
				// TODO Auto-generated method stub
				return new BookMyShow(source);
			}

			@Override
			public BookMyShow[] newArray(int size) {
				// TODO Auto-generated method stub
				return new BookMyShow[size];
			}
		};
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeParcelable(BookMyShow, flags);
	}

	private BookMyShowObject(Parcel in) {
		this.BookMyShow = (BookMyShow) in.readParcelable(BookMyShow.class
				.getClassLoader());
	}

	public static final Parcelable.Creator<BookMyShowObject> CREATOR = new Parcelable.Creator<BookMyShowObject>() {

		@Override
		public BookMyShowObject createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new BookMyShowObject(source);
		}

		@Override
		public BookMyShowObject[] newArray(int size) {
			// TODO Auto-generated method stub
			return new BookMyShowObject[size];
		}
	};

}
