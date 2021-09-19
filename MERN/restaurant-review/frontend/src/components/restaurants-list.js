import React from "react";
import RestaurantDataService from "../services/restaurant";

const RestaurantsList = props =>{

  const [restaurants, setRestaurants] = useState([]);
  const [searchName, setSearchName] = useState("");
  const [searchZip, setSearchZip] = useState("");
  const [searchCuisine, setSearchCuisine] = useState("");
  const [cuisines, setCuisines] = useState(["All Cuisines"]);

  useEffect(()=>{
    retrieveRestaurants();
    retrieveCuisines();
  }, []);

  const onChangeSearchName = e => {
    const searchName = e.target.value;
    setSearchName(searchName);
  }

  const retrieveRestaurants = () => {
    RestaurantDataService.getAll()
    .then(response =>{
      console.log(response.data);
      setRestaurants(response.data.restaurants);

    })
    .catch(e =>{
      console.log(e);
    })
  };

  const retrieveCuisines = () => {
    RestaurantDataService.getCuisines()
  }
  return (
    <div className="App">
     Hello World
    </div>
  );
}

export default RestaurantsList;
