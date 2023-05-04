const Books = ({ books }) => {
    return (
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {books.map((book) => (
          <div key={book.id} className="border rounded-md p-4">
            <div className="h-64">
              <img
                src={book.image}
                alt={book.title}
                className="w-full h-full object-cover rounded-md shadow-md"
              />
            </div>
            <div className="flex justify-between items-center mt-4">
              <h3 className="text-lg font-bold">{book.title}</h3>
              <span className="text-gray-500">${book.price}</span>
            </div>
            <div className="flex justify-between items-center mt-2">
              <span className="text-gray-500">{book.author}</span>
              <button className="bg-blue-500 text-white py-1 px-2 rounded-md">
                Add to cart
              </button>
            </div>
          </div>
        ))}
      </div>
    );
  };

  export default Books;