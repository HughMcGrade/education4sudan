class RequestsController < ApplicationController

  def index
  end

  def show
    @request = Request.find(params[:id])
  end

end
