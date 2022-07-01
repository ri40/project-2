import { createContext, useEffect, useState } from 'react';

const RecipeContext = createContext();

export const RecipeProvider = ({ children }) => {
   

  return (
    <RecipeContext.Provider>
      {children}
    </RecipeContext.Provider>
  );
};

export default RecipeContext;