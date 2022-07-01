import { Box, SimpleGrid } from '@chakra-ui/react';
import React from 'react';
import RecipeCard from '../components/RecipeCard';

// Recipe is parent component to RecipeCard

const Recipe = ({ recipes }) => {
  return (
    <>
      {recipes.map(recipe => (
        <RecipeCard
          key={recipe.id}
          title={recipe.title}
          image={`https://spoonacular.com/recipeImages/${recipe.image}`}
          prepTime={recipe.readyInMinutes}
          id={recipe.id}
          sourceUrl={recipe.sourceUrl}
        />
      ))}
    </>
  );
};

export default Recipe;
