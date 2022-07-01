import React from 'react';
import { ChakraProvider, theme } from '@chakra-ui/react';

import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { useEffect, useState } from 'react';

import Nav from './components/Nav';
// import Learn from './components/Learn';
import About from './components/About';
import Breakfast from './pages/Breakfast';
import Lunch from './pages/MainCourse';
import Appetizer from './pages/Appetizer';
import Salad from './pages/Salad';
import Dessert from './pages/Dessert';
import Hero from './components/Hero';
import Home from './pages/Home';

function App() {
  const [recipes, setRecipes] = useState([]);
  
  async function getRecipe(recipeType) {
    let API_KEY = 'c35119509fbb4636a4c5ca0021bd7a5f'
		const response = await fetch(
			`https://api.spoonacular.com/recipes/search?diet=vegan&type=${recipeType}&apiKey=${API_KEY}`,
			{
				headers: {
					'Content-Type': 'application/json',
					'Access-Control-Allow-Origin': '*',
					'Access-Control-Allow-Headers':
					'Accept, Authorization,Accept-Language, Content-Language, Content-Type, Cache-Control, Origin, X-Requested-With',
				},
			}
		);
		const data = await response.json();
		setRecipes(data.results);
		console.log(data.results);
	}
	console.log(recipes);
  // clears api fetch
  function clearRecipe() {
    setRecipes([]);
  }

  useEffect(() => {
    getRecipe();
  }, []);
  return (
    <ChakraProvider theme={theme}>
      <BrowserRouter>
        <Nav clearRecipe={clearRecipe} />

        <Routes>
          <Route path="/" element={<Home />} />
          <Route
            path="/breakfast"
            element={<Breakfast recipes={recipes} getRecipe={getRecipe} />}
          />
          <Route
            path="/lunch"
            element={<Lunch recipes={recipes} getRecipe={getRecipe} />}
          />
          <Route
            path="/appetizer"
            element={<Appetizer recipes={recipes} getRecipe={getRecipe} />}
          />
          <Route
            path="/salad"
            element={<Salad recipes={recipes} getRecipe={getRecipe} />}
          />
          <Route
            path="/dessert"
            element={<Dessert recipes={recipes} getRecipe={getRecipe} />}
          />
          <Route
            path="/about"
            element={<About recipes={recipes} getRecipe={getRecipe} />}
          />
          {/* <Route
            path="/learn"
            element={<Learn recipes={recipes} getRecipe={getRecipe} />}
          /> */}
        </Routes>
      </BrowserRouter>
    </ChakraProvider>
  );
}

export default App;
